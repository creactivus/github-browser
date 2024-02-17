# GitHub Browser

GitHub Browser is a Java project for browsing [GitHub](https://github.com/).

## Installation

Use [Apache Maven](https://maven.apache.org/) to install github-browser.
```bash
mvn clean install
```

## Usage

```bash
# run tests
mvn test

# run integration test
mvn test -Dtest="RepositoryControllerIT"

# run application
mvn spring-boot:run
```

## GET /api/repos/{username}
```bash
# returns non-forked repositories for a user
curl -H "Accept: application/json" http://localhost:8080/api/repos/{username}
```

```json
# sample output on user found
[
  {
    "name": "arc",
    "owner": "hornbeck",
    "branches": [
      {
        "name": "master",
        "lastCommit": "b57ea72aff051fc9f7fd003895f804dc81d760df"
      }
    ]
  },
  {
    "name": "blerb-core",
    "owner": "hornbeck",
    "branches": [
      {
        "name": "master",
        "lastCommit": "cfbe86545f97d2a058abf3fe7b63bfb22a5c9c3d"
      }
    ]
  }
]
```

```json
# sample output on user not found
{
  "status": "NOT_FOUND",
  "message": "User does not exist."
}
```

## License

[MIT](https://choosealicense.com/licenses/mit/)

