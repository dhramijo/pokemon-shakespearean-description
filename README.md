# Retrieve Pokemon Shakespearean Description


## Problem Description

There are successful brands who have managed to stay relevant for more than a decade without innovating too much.

We would like to offer a fresh perspective at the world or Pokemon: what if the description of each Pokemon we to be written using Shakespeare'e style?

To achieve this we would like to develop a REST API that, given a Pokemon name, returns its Shakespearean description.

### API Requirements

- Retrieve Shakespearean description

### **GET** endpoint: 

- **`/pokemon/<pokemon name>`**

### Usage example (using postman GET request):

- `http://localhost:8080/pokemon/blastoise`

**Output format:**

```
{
    "name": "blastoise",
    "description": "blastoise hath water spouts yond protrude from its shell. 
    The water spouts art very accurate. They can shoot bullets of water with 
    enow accuracy to strike exsufflicate cans from a distance of ov'r 160 feet."
}
```
### Pokemon 

You can find your favourite pokemon here: https://pokeapi.co/api/v2/pokemon


## How to run the program

1. Inside project folder run the below commands:

   - `mvn package`

   - `java -jar target/pokemon-shakespearean-description.jar`

2. Open Postman
  
   - Run **GET** request `http://localhost:8080/pokemon/blastoise`
   
## Utils

The project contains also DockerFile.


