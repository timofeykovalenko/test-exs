# test-exs

Test tasl

Directories:
- com.example.exercise.data - storage and models
- com.example.exercise.controllers - api service
- com.example.exercise.controllers - api controller

API:
```
POST /persons: Creates a person by sending a JSON request body with firstName and lastName fields. The response will contain the created person object.
GET /persons: Retrieves all persons as an array of person objects.
GET /persons/{id}: Retrieves a person by ID, where id is a path parameter
```
```
openapi: 3.0.3
info:
  title: Person API
  description: API for managing persons
  version: 1.0.0
servers:
  - url: http://localhost:8080
paths:
  /persons:
    post:
      summary: Create a person
      operationId: createPerson
      tags:
        - persons
      requestBody:
        description: Person object to be created
        required: true
        content:
          application/json:
            schema:
              $ref: '#/components/schemas/Person'
      responses:
        '201':
          description: Created
          content:
            application/json:
              schema:
                $ref: '#/components/schemas/Person'
    get:
      summary: Get all persons
      operationId: getAllPersons
      tags:
        - persons
      responses:
        '200':
          description: OK
          content:
            application/json:
              schema:
                type: array
                items:
                  $ref: '#/components/schemas/Person'
  /persons/{id}:
    get:
      summary: Get a person by ID
      operationId: getPersonById
      tags:
        - persons
      parameters:
        - name: id
          in: path
          description: ID of the person to retrieve
          required: true
          schema:
            type: integer
      responses:
        '200':
          description: OK
          content:
            application/json:
              schema:
                $ref: '#/components/schemas/Person'
components:
  schemas:
    Person:
      type: object
      properties:
        id:
          type: integer
          format: int64
        firstName:
          type: string
        lastName:
          type: string
      required:
        - firstName
        - lastName
```
