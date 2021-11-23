# RegexAPI

## API to check whether a string matches regular expression.
------------------------------------------------------------------------------------------------------------

#### Note: Uses Java Regex Package(java.util.regex) classes for computation. Certain characters in query string are interpreted diffrently due to URL encoding standards. Please check the list provided here : https://www.w3schools.com/tags/ref_urlencode.ASP

----------------------------------------------------

URL : localhost:XXXX/regex/expression

Parameters : regex,string

###### Example :

URL : localhost:XXXX/regex/expression?regex=ab*c&string=abc

JSON OUTPUT:

``
{
  "match": true,
  "matchingGroups": [
    "group 0 : abc"
  ]
}
``

###### Example :

URL : localhost:XXXX/regex/expression?regex=ab*c&string=abce

JSON OUTPUT:

``
{
  "match": false,
  "matchingGroups": null
}
``

###### Example :

URL : localhost:XXXX/regex/expression?regex=a(b*)ce&string=abce

JSON OUTPUT:

``
{
  "match": true,
  "matchingGroups": [
    "group 1 : b",
    "group 0 : abce"
  ]
}
``


