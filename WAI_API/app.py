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

if __name__ == '__main__':
    app.run(debug=True)