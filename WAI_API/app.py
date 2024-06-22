from flask import Flask, jsonify
import json
import random

app = Flask(__name__)
app.config['names'] = None  # Add a config to hold the names
    
def load_names():
    with open('names.json', 'r') as file:
        data = json.load(file)
        return data.get('names', [])


@app.route('/random-name', methods=['GET'])
def get_random_name():
    names = app.config['names'] or load_names()
    if len(names) > 2:  # Check if the list is not empty
        return jsonify({'name': random.choice(names)})
    else:
        return jsonify({'error': 'No names available'}), 404
    
@app.route('/random-name/<int:seed>', methods=['GET'])
def get_random_name_seed(seed):
    names = app.config['names'] or load_names()
    if len(names) > 4:  # Check if the list has at least four names
        random.seed(seed)  # Set the seed for the random number generator
        random_names = random.sample(names, 4)  # Get four random names
        return jsonify({'name': random_names})
    else:
        return jsonify({'error': 'No names available'}), 404

if __name__ == '__main__':
    app.config['names'] = load_names()  # Load names once during startup
    app.run(debug=True)