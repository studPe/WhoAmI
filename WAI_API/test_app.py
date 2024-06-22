import unittest
import json
from app import app, load_names

class TestApp(unittest.TestCase):

    def setUp(self):
        self.app = app.test_client()
        self.original_names = load_names()
        app.config['names'] = [
            "Elon Musk", "Angela Merkel", "Cristiano Ronaldo", "Taylor Swift",
            "Serena Williams", "Barack Obama", "Beyonce", "Jeff Bezos",
            "Lionel Messi", "Oprah Winfrey", "Bill Gates", "Kim Kardashian",
            "LeBron James", "Lady Gaga", "Roger Federer", "Mark Zuckerberg",
            "Rihanna", "Stephen Curry", "Emma Watson", "Vladimir Putin",
            "Ariana Grande", "Jennifer Lopez", "Novak Djokovic", "Justin Bieber",
            "Tom Brady", "Greta Thunberg", "Katy Perry", "Xi Jinping", "Ed Sheeran",
            "Meryl Streep", "Selena Gomez", "Usain Bolt", "Dwayne Johnson",
            "Ellen DeGeneres", "Adele", "Michael Jordan", "Kylie Jenner", "Tim Cook",
            "Michelle Obama", "J.K. Rowling", "Neymar", "Warren Buffett", "Drake",
            "Rafael Nadal", "Scarlett Johansson", "Sundar Pichai", "Chris Hemsworth",
            "Virat Kohli", "Emma Stone", "Jack Ma", "Malala Yousafzai", "Jennifer Aniston",
            "Brad Pitt", "Bruno Mars", "Angelina Jolie", "Leonardo DiCaprio",
            "Robert Downey Jr.", "Shah Rukh Khan", "Giannis Antetokounmpo", "Will Smith",
            "Harry Styles", "Taylor Lautner", "Larry Page", "Salman Khan", "Keanu Reeves",
            "Meghan Markle", "Benedict Cumberbatch", "Daniel Craig", "Margot Robbie",
            "Lewis Hamilton", "Shakira", "Johnny Depp", "Chris Evans", "Emma Thompson",
            "Jennifer Lawrence", "Sophie Turner", "Saoirse Ronan", "Timothee Chalamet",
            "Zendaya", "Millie Bobby Brown", "Gigi Hadid", "Bella Hadid", "Jason Momoa",
            "Henry Cavill", "Natalie Portman", "Adam Driver", "Daisy Ridley", "John Boyega",
            "Chadwick Boseman", "Tom Holland", "Chris Pratt", "Ana de Armas", "Gal Gadot",
            "Florence Pugh", "Joaquin Phoenix", "Cillian Murphy", "Andrew Garfield",
            "Benedict Wong", "Tom Hiddleston", "Idris Elba"
    ]

    def test_load_names(self):
        expected_names = [
            "Elon Musk", "Angela Merkel", "Cristiano Ronaldo", "Taylor Swift",
            "Serena Williams", "Barack Obama", "Beyonce", "Jeff Bezos",
            "Lionel Messi", "Oprah Winfrey", "Bill Gates", "Kim Kardashian",
            "LeBron James", "Lady Gaga", "Roger Federer", "Mark Zuckerberg",
            "Rihanna", "Stephen Curry", "Emma Watson", "Vladimir Putin",
            "Ariana Grande", "Jennifer Lopez", "Novak Djokovic", "Justin Bieber",
            "Tom Brady", "Greta Thunberg", "Katy Perry", "Xi Jinping", "Ed Sheeran",
            "Meryl Streep", "Selena Gomez", "Usain Bolt", "Dwayne Johnson",
            "Ellen DeGeneres", "Adele", "Michael Jordan", "Kylie Jenner", "Tim Cook",
            "Michelle Obama", "J.K. Rowling", "Neymar", "Warren Buffett", "Drake",
            "Rafael Nadal", "Scarlett Johansson", "Sundar Pichai", "Chris Hemsworth",
            "Virat Kohli", "Emma Stone", "Jack Ma", "Malala Yousafzai", "Jennifer Aniston",
            "Brad Pitt", "Bruno Mars", "Angelina Jolie", "Leonardo DiCaprio",
            "Robert Downey Jr.", "Shah Rukh Khan", "Giannis Antetokounmpo", "Will Smith",
            "Harry Styles", "Taylor Lautner", "Larry Page", "Salman Khan", "Keanu Reeves",
            "Meghan Markle", "Benedict Cumberbatch", "Daniel Craig", "Margot Robbie",
            "Lewis Hamilton", "Shakira", "Johnny Depp", "Chris Evans", "Emma Thompson",
            "Jennifer Lawrence", "Sophie Turner", "Saoirse Ronan", "Timothee Chalamet",
            "Zendaya", "Millie Bobby Brown", "Gigi Hadid", "Bella Hadid", "Jason Momoa",
            "Henry Cavill", "Natalie Portman", "Adam Driver", "Daisy Ridley", "John Boyega",
            "Chadwick Boseman", "Tom Holland", "Chris Pratt", "Ana de Armas", "Gal Gadot",
            "Florence Pugh", "Joaquin Phoenix", "Cillian Murphy", "Andrew Garfield",
            "Benedict Wong", "Tom Hiddleston", "Idris Elba"
        ]
        self.assertEqual(load_names(), expected_names)

    def test_get_random_name(self):
        response = self.app.get('/random-name')
        self.assertEqual(response.status_code, 200)
        data = json.loads(response.data)
        self.assertIn('name', data)
        self.assertIn(data['name'], load_names())

    def test_get_random_name_with_seed(self):
        response = self.app.get('/random-name/1')
        self.assertEqual(response.status_code, 200)
        data = json.loads(response.data)
        self.assertIn('name', data)
        self.assertEqual(len(data['name']), 4)

        # Test when Liste wenioer als 4 Namen enthält	
        app.config['names'] = ['Alice', 'Bob', 'Charlie']
        response = self.app.get('/random-name/1')
        self.assertEqual(response.status_code, 404)
        data = json.loads(response.data)
        self.assertEqual(data.get('error'), 'No names available')

if __name__ == '__main__':
    unittest.main()