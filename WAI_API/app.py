from flask import Flask, jsonify
import json
import random

app = Flask(__name__)

def load_names():
    with open('names.json', 'r') as file:
        data = json.load(file)
        return data.get('names', [])

@app.route('/random-name', methods=['GET'])
def get_random_name():
    names = load_names()
    if names:  # Check if the list is not empty
        return jsonify({'name': random.choice(names)})
    else:
        return jsonify({'error': 'No names available'}), 404
    
@app.route('/random-name/<int:seed>', methods=['GET'])
def get_random_name_seed(seed):
    names = load_names()
    if names and len(names) >= 4:  # Check if the list has at least four names
        random.seed(seed)  # Set the seed for the random number generator
        random_names = random.sample(names, 4)  # Get four random names
        return jsonify({'name': random_names})
    else:
        return jsonify({'error': 'No names available'}), 404

if __name__ == '__main__':
    app.run(debug=True)

def test_load_names():
    assert load_names() == ['Alice', 'Bob', 'Charlie']

def test_get_random_name():
    response = app.test_client().get('/random-name')
    assert response.status_code == 200
    data = json.loads(response.data)
    assert data.get('name') in ['Alice', 'Bob', 'Charlie']

    # Test when the list is empty
    app.config['names'] = []
    response = app.test_client().get('/random-name')
    assert response.status_code == 404
    data = json.loads(response.data)
    assert data.get('error') == 'No names available'