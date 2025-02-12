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
  "nom": "eeee",
  "code": "aaa",
  "description": "un super hotdog",
  "prix": 5,
  "etat": {
    id: 2
  }
}'''
```
