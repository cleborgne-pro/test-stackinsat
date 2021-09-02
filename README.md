# Réponses du test

1) Retourner tous les éléments book
```
//book

Résultat:
toto1 titi
toto2 titi
toto3 titi
toto4 titi2
toto5 titi
```

2) Retourner tous les éléments title ayant comme parent un élément book avec un attribut type égal à roman
```
//book[@type='roman']//title

Résultat:
toto3
toto5
```

3) Retourner le nombre d'éléments book ayant un attribut type égal à bd
```
count(//book[@type='bd'])

Résultat:
1
```

4) Que renvoie la requête XPath suivante :  /library/library/ancestor-or-self::library
```
Résultat:
toto1 titi toto2 titi toto3 titi toto4 titi2 toto5 titi
toto5 titi

Explication:
Le contenu de library ainsi que le contenu de tous ses parents
```

# Documentation

Swagger est installé et disponible à cette url:

```
http://localhost:8080/swagger-ui/index.html
```