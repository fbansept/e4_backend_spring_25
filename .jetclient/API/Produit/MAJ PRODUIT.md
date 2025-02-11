```toml
name = 'MAJ PRODUIT'
method = 'PUT'
url = 'http://localhost:8080/produit/3'
sortWeight = 5000000
id = 'e1c4c6df-d87e-499d-bc8d-69f59434b85c'

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
