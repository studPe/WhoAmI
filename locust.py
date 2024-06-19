import random
from locust import HttpUser, TaskSet, task, between

class UserBehavior(TaskSet):
    @task
    def index(self):
        self.client.get("/random-name")

    @task
    def about(self):
        random_int = random.randint(1, 100)  # Generate a random integer between 1 and 100
        self.client.get(f"/random-name/{random_int}")

class WebsiteUser(HttpUser):
    tasks = [UserBehavior]
    wait_time = between(1, 5)
