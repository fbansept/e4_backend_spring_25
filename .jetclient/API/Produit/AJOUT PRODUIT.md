```toml
name = 'AJOUT PRODUIT'
method = 'POST'
url = 'http://localhost:8080/produit'
sortWeight = 3000000
id = 'b4be272d-6133-469a-87a8-01ae80e15707'

[body]
type = 'JSON'
raw = '''
{
  "nom": "hot dog !!!!!!",
  "code": "hotdodog",
  "description": "un super hotdog",
  "prix": 2.9,
  "etat": {
    id: 2
  }
}'''
```
