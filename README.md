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


## How to run the program

1. Create a folder where to download the project and inside it run the below commands:

   - $ git clone https://github.com/dhramijo/pokemon-shakespearean-description.git

   - $ mvn spring-boot:run

2. Open Postman
  
   - Run **GET** request http://localhost:8080/pokemon/blastoise
   
## Utils

- **Swagger API Documentation** can be accessible via
  - http://localhost:8080/swagger-ui.html

- The project contains also **DockerFile**.

- With **httpie** you can run the GET request as:
  - `http http://localhost:8080/pokemon/blastoise` 

- Useful APIs:
  - **Shakespeare translator**: https://funtranslations.com/api/shakespeare
  - **PokeAPI**: https://pokeapi.co/docs/v2.html/
  - **Pokemons**: You can find your favourite Pokemon here: https://pokeapi.co/api/v2/pokemon


