# **PROJEKT TKOM**

**Autor**: Krzysztof Kluczyński 318672<br>
**Prowadząca**: Agnieszka Malanowska<br>
**Temat nr 8**: Język z wbudowanym typem słownika, którego zawartość można sortować.<br>

## **<br>Opis:**
Tematem projektu jest realizacja interpretera języka z wbudowanym typem słownika. 
Zawartość struktury można sortować, wykonując dedykowaną do tego metodę, przyjmującą wyrażenie w stylu _lambda_ jako parametr określający sposób sortowania.
Wykonanie tej metody powoduje zmianę kolejności iterowania po elementach struktury.
Możliwe są także wszystkie podstawowe operacje na słowniku: 
* Dodawania elementów
* Usuwanie elementów
* Modyfikowanie elementów 
* Wyszukiwanie elementów według klucza
* Sprawdzenie, czy klucz znajduje się w słowniku
* Iterowanie po słowniku

Język pozwala także na wykonywanie zapytań w stylu LINQ, 
umożliwiających wyszukiwanie, filtrowanie oraz przejrzyste zwrócenie danych w sposób określony przez użytkownika.
<br>
<br>
Do implementacji wykorzystano język Java 17.
Decyzja o wykorzystaniu tego języka została podjęta głównie ze względu na fakt,
że jest to jedna z nowszych wersji języka Java o długoterminowym wsparciu (LTS).
Korzystanie z LTS wersji Java zapewnia stabilność, bezpieczeństwo oraz długoterminowe wsparcie ze strony producenta.


### **<br>Cechy języka:**
* **Statyczne typowanie**, wszystkie typy danych muszą być jasno zadeklarowane zgodnie ze składnią języka
* **Silne typowanie**, automatyczne konwersje między typami nie są obsługiwane, takie operacje wymagają jasnego zdefiniowania za pomocą wbudowanych w język mechanizmów 
* **Referencje**, argumenty są przekazywane do funkcji oraz metod przez referencję (podobnie jak w języku Python)
* **Mutowalność**, zmienne są mutowalne
* **Funkcja main**, plik źródłowy musi zawierać jedną bezargumentową funkcję main zwracającą int
* **Zakres zmiennych**, zmienne są widoczne jedynie w bloku kodu między nawiasami klamrowymi {}, gdy zostały w nim zainicjowane lub przekazane jako parametr w przypadku funkcji.


## **<br>Instrukcja uruchomienia:**

Aby zbudować projekt, należy wykonać komendę:

```
mvn clean install
```

Aby uruchomić interpreter, konieczna jest zainstalowana Java 17. Uruchamiamy go przy użyciu wcześniej spakowanego pliku jar, za pomocą polecenia zawierającego jako argumenty ścieżki do pliku jar oraz pliku z naszym kodem:

```
java -jar <jar file path> <file path>
```

Wynik działania naszego programu powinien wyświetlić się w konsoli.


## **<br>Najważniejsze konstrukcje językowe wraz z przykładami:**
* **Komentarze**
  * Komentarz jednoliniowy
    ```
    //This is comment
    ``` 
    
    <br>
* **Typy danych:** 
    * `bool`: Reprezentuje wartości logiczne, które mogą być `True` lub `False`.
    * `int`: Reprezentuje liczby całkowite z zakresu od -2147483648 do 2147483648.
    * `float`: Reprezentuje liczby zmiennoprzecinkowe pojedynczej precyzji z zakresu od 1.40129846432481707e-45 do 3.40282346638528860e+38.
    * `String`: Reprezentuje sekwencję znaków, która może zawierać litery, cyfry, białe znaki oraz znaki specjalne, o maksymalnej długości 200 znaków.
      ```
      bool var_bool = True;
      int var_int = 2;
      float var_float = 3.2;
      String var_string = "Hello";
      
      ```

    <br>
* **Kolekcje:**
    * `List`: Kolekcja elementów uporządkowanych, która pozwala na przechowywanie wielu elementów o tym samym.
    Dostępne operacje:
      * `add` - pozwala na dodanie elementu do listy
      * `delete` - pozwala na usunięcie elementu z listy 
      * `get` - zwraca konkretny argument z listy, przyjmuje indeks jako parametr
      * `set` - zmiana konkretnej wartości w tablicy, pierwszy argument to indeks, drugi to wartość
        ```
        List<int> var_list = [1, 2, 3, 4, 5];
        
        var_list.add(12); //dodanie elementu na koniec listy
        var_list.delete(0) //usunięcie pierwszego elementu z listy
        var_list.get(0) //uzyskanie pierwszego elementu z listy
        var_list.set(0, 2) //ustawienie wartości znajdującej się na pozycji o indeskie 0 na 2
        ```
    * `Tuple`: Krotka jest kolekcją elementów o różnych typach, które są traktowane jako pojedyncza jednostka.
    Dostępne operacje:
        * `get` - zwraca wartość, która znajduje się pod podanym jako parametr indeksem
        * `set` - zmiana konkretnej wartości w tablicy
    
         ```
         Tuple<String, int> var_tuple = ("dog", 3);
      
        var_tuple.get(0) //uzyskanie pierwszego elementu z listy
        var_tuple.set(0, 2) //ustawienie wartości znajdującej się na pozycji o indeskie 0 na 2
         ```
    * `Dictionary`: Kolekcja par klucz-wartość, gdzie każdy klucz musi być unikalny, a wartości mogą być dowolnego typu.
    Dostępne operacje:
        * `add` - dodanie elementu do słownika, przyjmuje dwa argumenty, klucz i wartość
        * `delete` - usuwa pare klucz-wartość ze słownika, argument to klucz z pary, która ma zostać usunięta
        * `get` - zwraca wartość dla podanego klucza
        * `set` - ustawia nową wartość dla podanego klucza, przyjmuje dwa argumenty, klucz i wartość
        * `ifexists` - sprawdzenie, czy klucz występuje w słowniku
        * `sort` - sortuje zawartość słownika według wskazanego przez użytkownika schematu
      
      ```
      Dictionary<String, int> var_dict = |
          "dog": 3,
          "cat": 4,
          "cow": 5,
          "hamster": 6 
      |;
      
      int a = var_dict.get("dog");
      bool b = var_dict.ifexists("hamster")
      var_dict.delete("hamster");
      var_dict.add("hamster", 6);
      var_dict.set("sheep", 7);
      
      // Przykłady sortowania - dokładne omówienie poniżej
      // Sortowanie po wartościach rosnąco
      var_dict.sort((a, b) => a.Value - b.Value);

      // Sortowanie po wartościach malejąco
      var_dict.sort((a, b) => b.Value - a.Value);

      // Sortowanie po długości klucza rosnąco
      var_dict.sort((a, b) => a.Key.length() - b.Key.length());

      // Sortowanie po długości klucza malejąco
      var_dict.sort((a, b) => b.Key.length() - a.Key.length());

      // Sortowanie alfabetyczne kluczy z użyciem funkcji compare 
      var_dict.sort((a, b) => a.Key.compare(b.Key)); 
      ```
      Omówienie przykładowych sortowań
      1. Sortowanie po wartościach rosnąco:<br>
      (a, b) => a.Value - b.Value oznacza, że elementy zostaną posortowane w kolejności rosnącej na podstawie ich wartości.
      Jeśli wartość a jest mniejsza niż wartość b, wynik będzie ujemny, co spowoduje, że a zostanie umieszczone przed b w posortowanej kolejności. 
      Jeśli wartość a jest większa niż wartość b, wynik będzie dodatni, co spowoduje umieszczenie b przed a. Jeśli są równe, wynik będzie zero, co oznacza, że ich kolejność nie ulega zmianie.

      2. Sortowanie po wartościach malejąco:<br>
      (a, b) => b.Value - a.Value to odwrócona kolejność porównania. Tutaj wartości są porównywane w odwrotnej kolejności, co powoduje sortowanie malejące.

      3. Sortowanie po długości klucza rosnąco:<br>
      (a, b) => a.Key.length() - b.Key.length() porównuje długości kluczy a i b. Elementy zostaną posortowane według długości ich klucza, od najkrótszego do najdłuższego.

      4. Sortowanie po długości klucza malejąco:<br>
      (a, b) => b.Key.length() - a.Key.length() to odwrócona kolejność porównania długości kluczy. Elementy zostaną posortowane według długości ich klucza, od najdłuższego do najkrótszego.
        
      5. Sortowanie alfabetyczne kluczy z użyciem funkcji compare:<br>
      (a, b) => a.Key.compare(b.Key) wykorzystuje funkcję compare do porównania kluczy. Wartości zwracane przez compare decydują o kolejności sortowania.
      Jeśli a.Key jest leksykograficznie mniejsze od b.Key, wynik będzie ujemny, co spowoduje, że a zostanie umieszczone przed b. Jeśli jest większe,
      wynik będzie dodatni, co spowoduje umieszczenie b przed a. Jeśli są równe, wynik będzie zero, co oznacza, że ich kolejność nie ulega zmianie.
      <br>// Czy można zapisać lepiej/czytelniej powyzsze lambdy?
        
    <br>
* **Operatory logiczne:**
  * `and` - operator koniunkcji
  * `or` - operator alternatywy
  * `not` - operator negacji
  
    Przykładowe operacje: 

    ```
    bool var_true = True;
    bool var_false = False;
    
    //operatory można łączyć w bardziej zaawanasowane wyrażenia używając nawiasów
    bool a = var_true and (not var_false); // a = True
    bool b = var_true and (var_true or var_false); // b = False
    ```

    <br>
* **Operatory arytmetyczne:**
    <br> Dostępne dla typów liczbowych, dodawanie również dla typu String.
  * `*`      - operator mnożenia
  * `/`       - operator dzielenia
  * `+`      - operator dodawania
  * `-`    - operator odejmowania
    ```
    int first = 4;
    int second = 3;
    int third = 2;
    
    // dzielenie dwóch zmiennych typu integer również zwraca integer, czyli po wykonaniu poniższej linii zmienna resultOne = 1
    int resultOne = second / third;  
    
    //zachowana jest kolejność działań zgodna z matematyką, czyli po wykonaniu poniższej linii zmienna resultTwo = 14
    int resultTwo = 2 + first * second;
    
    //możliwia jest operacja dodawania dla typu String
    String hello = "Hello " + "World";
    ```

    <br>
* **Operatory porównania:**
    * `==`: Oznacza równość, sprawdza, czy dwa elementy są równe.
    * `!=`: Oznacza nierówność, sprawdza, czy dwa elementy nie są równe.
    * `<`: Oznacza mniej niż, sprawdza, czy pierwszy element jest mniejszy niż drugi.
    * `<=`: Oznacza mniejsze bądź równe, sprawdza, czy pierwszy element jest mniejszy lub równy drugiemu.
    * `>`: Oznacza większe niż, sprawdza, czy pierwszy element jest większy niż drugi.
    * `>=`: Oznacza większe bądź równe, sprawdza, czy pierwszy element jest większy lub równy drugiemu.
  
      ```
      int a = 2;
      bool var = a < 1; 
      bool var1 = a != 2;
      bool var2 = a >= 2;
      
      //przyklady rowniez w sekcji "petle warunkowe"
      ```

    <br>
* **Instrukcje warunkowe:** 
    * `if`: Instrukcja warunkowa, która wykonuje określony blok kodu, jeśli warunek jest spełniony.
      ```
      int a = 3;
        
      if (a != 2) {
          a = a + 2;
      }
      ```
    * `if-else`: Instrukcja warunkowa, która wykonuje określony blok kodu, jeśli warunek jest spełniony, a inny blok kodu, jeśli warunek nie jest spełniony.
      ```
      int a = 2;
      int b;
      
      if (a >= 2) {
            b = 2;
      } else {
            b = 0;  
      }
      ```

    * `if-elseif`: Instrukcja warunkowa, która wykonuje różne bloki kodu w zależności od spełnienia warunków.

      ```

      int a = 2;

      int b;

      
      if (a == 2) {

            b = 2;

      } elseif (a < 2) {

            b = -3;  

      } else {
            b = 3;
      }

      ```


* **Pętle warunkowe:**
    * `while`: Pętla, która wykonuje określony blok kodu, dopóki podany warunek jest spełniony.
      ```
      int x = 2;
    
      while (x != 5) {
          x = x + 1;
      }
      ```

  <br>
* **Funkcje:**
    <br>W języku, każda funkcja zaczyna się od słowa kluczowego `fn` (skrót od function), po którym następuje deklaracja typu zwracanego funkcji - jeśli funkcja nic nie zwraca, typ ten jest `void`. Każdy argument funkcji musi być również opisany przez swój typ. Ciało funkcji znajduje się w nawiasach klamrowych.
    <br>Zmienne przekazywane do funkcji są przekazywane przez referencję, co oznacza, że funkcja może modyfikować ich wartość.
    <br>Nie ma możliwości przeciążania funkcji.
    <br>Funkcje mogą być wywoływane rekursywnie - funkcja może wywołać samą siebie podczas wykonywania. Maksymalne ograniczenie na liczbę wywołań rekurencyjnych wynosi 200 (patrz sekcję "Obsługa błędów").
    <br>Aby program działał poprawnie, musi zawierać dokładnie jedną specjalnie zdefiniowaną funkcję, zwyczajowo nazywaną `main`. Jest to funkcja, od której zaczyna się wykonywanie programu. W języku `main` zazwyczaj zwraca wartość całkowitą (typ `int`) jako kod wyjścia programu.<br><br>

     * funkcja niezwracająca wartości

       ```
       //funkcja wypisująca na ekran czy podana liczba jest parzysta oraz jej wywołanie w main
       fn void printIfEven(int number) {
          if ((number / 2) * 2 != number) {
              print("The number is odd.");
          } else {
              print("The number is even.");
          }
       }
      
      
       fn int main() {
          int x = 26;
          printIfEven(x);
    
          return 0;
       }
       ```

     * funkcja bezargumentowa
       ```
       //funkcja zwracająca maksymalną możliwą liczbę typu int oraz jej wywowłanie w funkcji main
       fn int getMaxInt() {
           return 2147483647;
       }
    
    
       fn int main() {
           int x = getmaxInt();
           print(($String x))
           return 0;
       }
       ```
      
       <br>
     * **Klasy:**
         <br> W języku możliwe jest także tworzenie klas poprzez użycie słowa kluczowego `class` <br>
         Wewnątrz klasy możemy tworzyć pola oraz metody, nie występują modyfikatory dostępu, zakładamy, że wszystkie pola oraz metody są publiczne.
         Nie występuje możliwość przeciążania metod.<br><br>

          * definicja klasy

               ```
               class Counter {
        
                 constructor(int pNumber) {
                     int number = pNumber;
                 }
      
                 fn int getNumber() {
                     return number;
                 }
      
                 fn void setNumber(int pNumber) {
                     number = pNumber;
                 }
      
                 fn void increment() {
                      number = number + 1; 
                 }
      
                 fn void decrement() {
                     number = number - 1;
                 }
      
        
                 fn void printNumber() {
                     print("current value: " + ($String number);
                 }
      
               }
      
      
               fn int main() {
                   int x = 1;
                   Counter counter = Counter(x);
                   counter.increment();
                   counter.printNumber();
               }
              ``` 
       <br>
* **Funkcje wbudowane:**
    * print
      <br>Funkcja print powoduje wypisanie tekstu w konsoli, przyjmuje jedynie argumenty typu String. 
      ```
      fn int main() {
          print("Hello");
          return 0;
      }
      ```

    <br>
* **Operatory rzutowania:**
    <br> Z racji tego, że język jest statycznie typowany, zostały utworzone mechanizmy rzutowania. Aby rzutować zmienną na inny typ, musimy użyć `$` oraz nazwy typu, na jaki rzutujemy.<br>
    W przypadku rzutowania `float` na `int` cyfry po przecinku są ucinane. 

    * int na float: rzutowanie bezstratne
      ```
      fn int main() {
          int x = 2;
          float y = ($float x); // y = 2.0
          return 0;
      }
      ```
    * float na int: obcięcie cyfr po przecinku
      ```
      fn int main() {
          float x = 3.33;
          int y = ($int x); // y = 3
          return 0;
      }
      ```
    * int na string
      ```
      fn int main() {
          int x = 3;
          String y = ($String x);
          return 0;
      }
      ```
    * float na string
      ```
      fn int main() {
          float x = 3.2;
          String y = ($String x);
          return 0;
      }
      ```
    * string na int
      ```
      fn int main() {
          String x = "3";
          int y = ($String x);
          return 0;
      }
      ```
    * string na float
      ```
      fn int main() {
          String x = "3.2";
          float y = ($float x);
          return 0;
      }
      ```

    <br>
* **Zapytania na słownikach:** 
    * zapytania deklaratywne
      ```
      Dictionary<String, int> var_dict = |
          "dog": 3,
          "cat": 4,
          "cow": 1,
          "hamster": 6
      |;
      
      List<Tuple<String, int>> query_result = 
                                SELECT 
                            (var_dict.key, var_dict.value)
                                FROM
                            var dict
                                WHERE
                            var_dict.value > 2
                                ORDER BY
                            var_dict.value
                                ASC

      List<String> query_result2 = 
                                SELECT 
                            (var_dict.key)
                                FROM
                            var dict
                                WHERE
                            var_dict.value > 2
                                ORDER BY
                            var_dict.value
                                DESC
      ```

## **<br>Gramatyka:**
```
 program                 = {definition}
 definition              = function_defintion | comment | class_definition
 function_definition     = "fn",  type | "void", identifier, "(", parameters-list, ")", block;
 class_definition        = "class", identifier, "{" , class_member, "}";

 block                   = "{", { statement }, "}";
 statement               = comment
                         | conditional
                         | loop
                         | block
                         | declaration
                         | assignment
                         | function_call
                         | return_statement;
                        
 class_member            = declaration 
                         | method_declaration 
                         | constructor_declaration //czy konstruktor jest wymagany? wystarcza settery zdefiniowane przez uzytkownika?
                        
 constructor_declaration = "constructor", "(", parameters-list, ")", block;
 
 method_declaration      = function_definition;                       
                        
 conditional             = "if", "(", expression, ")", block,
                          { "elseif", "(", expression, ")", block },
                          [ "else", block ];
                                                                         
 loop                    = "while", "(", expression, ")", block;
 
 declaration             = (type, identifier) ";" ;
 
 assignment              = [type], identifier, "=", (expression) | query_statement, ";"; //czy mozna lepiej rozpisać/umiejscowić query statement w tej gramatyce?
 
 function_call           = expression, "(", arguments-list, ")", ";";
 
 return_statement        = "return", [ expression ], ";";

 
 
 query_statement         = "SELECT", select_clause, "FROM", identifier, [where_clause], [order_by_clause];
 
 select_clause           = "(", select_item, { ",", select_item }, ")";
 
 select_item             = identifier , ".", ("key" | "value);

 where_clause            = "WHERE", expression;

 order_by_clause         = "ORDER BY", identifier, ("ASC" | "DESC"), ";";
 
 lambda_expression       = "(", identifier, ",", identifier, ")", "=>", expression;
 
 
 
 expression              = conjunction, { "or", conjunction }; 
 
 conjunction             = relation_term, { "and", relation_term };
 
 relation_term           = additive_term, [ relation_operator , additive_term ];
 
 additive_term           = multiplicative_term, { add_sub_operator, multiplicative_term };
 
 multiplicative_term     = factor, { mul_div_operator, factor };
 
 parameters-list         = [ type, identifier, { ",", type, identifier } ]; //lista parameterow w deklaracji funkcji/metody
 
 arguments-list          = [ expression, { ",", expression } ]; //lista argumentow podawana przy wywolaniu funkcji
   
 factor                  = ["not"],
                         |literal 
                         | "(", expression, ")" 
                         | identifier, ".", identifier //odwolanie sie do pola obiketu
                         | identifier, ".", function_call //wywolanie metody na obiekcie
                         | "sort", ".", "(", lambda_expression, ")"; //wywolanie sortowania na slowniku, czy mozna zrobic lepiej?
                         | identifier 
                         | cast_expression 
                         | object-creation;

 object-creation         = identifier, "(", [arguments-list], ")"; //dodanie słowa kluczowego new mprzy tworzeniu?

 cast_expression         = "(", $", type, (identifier | literal), ")";

 //CZĘŚĆ LEKSYKALNA?                    
 type                    = type_basic | type_complex

 type_complex            = dictionary_declaration | tuple_declaration | list_declaration
 type_basic              = "int" | "float" | "string" | "boolean";

 dictionary_declaration  = "Dictionary", "<", type_basic, ",", type_basic, ">";
 tuple_declaration       = "Tuple", "<", type_basic, ",", type_basic, ">";
 list_declaration        = "List", "<", type_basic, ">" ;

 literal                 = boolean | string | integer | float | complex_literal;
 complex_literal         = dictionary_literal | tuple_literal | list_literal

 dictionary_literal      = "|", {literal, ":", literal, ","}, "|";
 tuple_literal           =  "(", literal, ",", literal, ")";
 list_literal            = list_type = "[", [literal, {",", literal}], "]";

 boolean                 = "true" | "false";
 string                  = '"', { character - newline }, '"';
 float                   = ["-"], integer, ".", [ integer ];
 integer                 = ["-"], digit_positive, { digit };

 identifier              = letter, { identifier_chars };
 identifier_chars        = alphanumeric | "_";
 alphanumeric            = letter | digit;

 add_sub_operator        = "+" | "-"
 mul_div_operator        = "*" | "/"
 assign_operant          = "="
 relation_operator       = "<" | "<=" | "==" | ">" | ">=" | "!="

 digit                   = [0-9];
 non_zero_digit          = [1-9];
 zero                    = "0";
 letter                  = [a-zA-Z];
 comment                 = "//", { character - newline }, newline;
 newline                 = "\n"
 character               = .; //dowolny znak unicode
```


## **<br>Obsługa błędów:**

Błędy programu są komunikowane użytkownikowi poprzez komunikaty wyświetlane w konsoli.
Wszystkie błędy są traktowane równorzędnie i powodują zatrzymanie wykonywania programu.
Poniżej znajduje się format komunikatu o błędzie:

```
ERROR in <Line Number>:<Column Number> | <Error message>
```

### Przykładowe błędy
* Niepoprawna składnia
  ```
  fn int main() {
    int x = 3 //brak średnika
    iny y = 4; //literówka
    return 0;
  }
  ```
  ```
  ERROR in <Line Number>:<Column Number> | Syntax Error
  ```
* Niedozwolona operacja na typach
  ```
  fn int main() {
    int x = 3 //brak średnika
    print("The number is: " + x)
    return 0;
  }
  ```
  
  ```
   ERROR in <Line Number>:<Column Number> | operator "+" not applicable to types String and int
  ```
  
* Odwołanie się do nieistniejącej zmiennej/funkcji
    ```
    fn int main() {
      int x = 3;
      float y = a + ($float x);
      return 0;
  }
  ```

  ```
   ERROR in <Line Number>:<Column Number> | variable "a" undefined
  ```
* przypisanie niepoprawnej wartości do typu LUB typ deklarowany różny od przekazanego (również w przypadku złożonych struktur i wartości zwracanych przez funkcję)
    ```
    fn int main() {
      Dictionary<String, int> = |
          12: "cat"
      |
      return 0;
  }
  ```

  ```
  ERROR in <Line Number>:<Column Number> | cannot assign value of type int to type float
  ```

* próba niejawnej konwersji
    ```
    fn int main() {
      int x = 3;
      String a = x;
      return 0;
  }
  ```

  ```
  ERROR in <Line Number>:<Column Number> | cannot assign type int to type String
  ```
* Utworzenie funkcji/zmiennej/klasy o tej samej nazwie
    ```
    fn int add(int x, int y) {
      return x+y;
    }  
    
    fn float add(float x, float y) {
      return x+y;
    }
  
    fn int main() {
      int x = 3;
      String a = x;
      return 0;
  }
  ```

  ```
  ERROR in <Line Number>:<Column Number> | function "add" redefined
  ```

* Brak zdefiniowanej funkcji main w programie

  ```
  ERROR in <Line Number>:<Column Number> | Missing definition of the main function in the program
  ```

* Definicja zmiennych poza {} (utworzenie zmiennej globalnej)
  ```
  int global_variable;
  
  fn int main() {
    int x = 3;
    String a = x;
    return 0;
  }
  ```
  ```
  ERROR in <Line Number>:<Column Number> | Variable defined outside scope (global variable creation)
  ```
* Odwołanie się do zmiennej spoza {}
  ```
  ERROR in <Line Number>:<Column Number> | Accessing variable beyond scope
  ```
* Brak return w funkcji
  ```
  ERROR in <Line Number>:<Column Number> | Missing return statement in non-void function
  ```

  * Wywołanie funkcji ze złą liczbą argumentów
  ```
  fn int add(int x, int y) {
      return ($float x) + (float $y);
  }


  fn int main() {
    int x = add(1, 2);
  }
  ```
  ```
  ERROR in <Line Number>:<Column Number> | Wrong number of arguments, expected 2
  ```
* Zbyt długi łańcuch String
  ```
  ERROR in <Line Number>:<Column Number> | String too long (max size is 100)
  ```
* Wartość int poza zakresem
  ```
  ERROR in <Line Number>:<Column Number> |  int outside the allowed range
  ```
* Wartość float poza zakresem
  ```
  ERROR in <Line Number>:<Column Number> | float outside the allowed range
  ```
* Przekroczenie maksymalnej liczby wywołań rekurencji
  ```
  ERROR in <Line Number>:<Column Number> | Maximum recursion depth exceeded.
  ```


## **<br>Wymagania funkcjonalne:**
* Interpreter pozwala na uruchomienie kodu zapisanego w pliku tekstowym
* Język obsługuje podstawowe typy danych(int, float, bool) oraz konstrukcje językowe (pętle, instrukcje warunkowe)
* Język pozwala na wykonywanie podstawowych operacji arytmetycznych i logicznych na zmiennych
* Język posiada kolekcje - listy i słowniki
* Na słownikach możliwe jest wywołanie metody sort(), która zmieni kolejność elementów w słowniku zgodnie z wyrażeniem, które poda użytkownik jako parametr
* Na słownikach możliwe jest wykonanie zapytania w stylu LINQ(deklaratywnie), które zwróci przefiltrowane wartości we wskazanej kolejności
* język umożlwia tworzenie własnych funkcji
* język umożliwia tworzenie własnych klas
* Język jest statycznie typowany
* Język jest silnie typowany
* Zmienne są mutowalne
* Zmienne są przekazywane do funkcji przez referencję

## **<br>Wymagania niefunkcjonalne:**
* Interpreter powinien zapewniać deterministyczne działanie, co oznacza, że ten sam kod źródłowy zawsze produkuje te same wyniki przy identycznych warunkach wejściowych, zapewniając stabilność działania aplikacji.
* Interpreter powinien być łatwy do rozszerzania o dodatkowe funkcje i biblioteki, co umożliwia tworzenie bardziej zaawansowanych programów w oparciu o ten język.
* Interpreter powinien być odpowiednio udokumentowany, aby ułatwić użytkownikom korzystanie z niego, opisując składnię języka, dostępne funkcje, typy danych itp.
* Język zawiera jedynie podstawowe konstrukcje, przez co jest prosty do nauki
* Mechanizm sortowania słownika powinien być zoptymalizowany pod kątem wydajności

## **<br>Zwięzły opis realizacji:**
Program będzie składał się z modułów, które będą odpowiedzialne za kolejne etapy analizy oraz przetwarzania plików wejściowych. 
Cały proces będzie wspierany przez dodatkowe moduły m.in. moduł obsługi błędów. Poniżej krótkie omówienie modułów oraz ich podstawowych założeń

**1. Analizator leksykalny (Lekser)**
<br>Lekser jest kluczowym modułem odpowiedzialnym za analizę leksykalną tekstu źródłowego.
Jego głównym zadaniem jest przekształcenie ciągu znaków na sekwencje tokenów, które stanowią podstawowe jednostki leksykalne języka programowania.

<br>Proces działania leksera polega na czytaniu kodu źródłowego znak po znaku, aż do momentu wykrycia sekwencji odpowiadającej jednemu zdefiniowanemu tokenowi.
Gdy token zostanie poprawnie zidentyfikowany, jest on przekazywany do parsera. Istotne jest, że lekser czyta nowe znaki tylko wtedy, gdy parser o to wyraźnie prosi.
Taka strategia pomaga w optymalizacji całego procesu analizy tekstu źródłowego.

Tokeny zdefiniowane w języku(Nazwa Tokenu `typ`):
* Operatory arytmetyczne
  * Plus `+` 
  * Minus `-`
  * Multiply `*`
  * Divide `/`
* Operatory porównania
  * Equal `=`
  * NotEqual `!=`
  * Greater `>`
  * Less `<`
  * LessEqual `<=`
  * GreaterEqual `>=`
* Operatory logiczne
  * And `and`
  * Or `or`
  * Not `not`
* Typy
  * Integer `int`
  * Float `float`
  * Bool `bool`
  * String `String`
  * Dictionary `Dictionary`
  * List `List`
  * Tuple `Tuple`
  * Void `void`
* Nawiasy
  * BraceOpen `{`
  * BraceClose `}`
  * BracketOpen `(`
  * BracketClose `)`
  * SquareBracketOpen `[`
  * SquareBracketClose `]`
  * Pipe `|`
  * LessForTypeDefinitionOpen `<` //czy potrzebujemy definiować to oddzielnie? to ten sam znak co Less
  * GreaterForTypeDefinitionClose `>`
* Pętle i instrukcje warunkowe
  * While `while`
  * If `if`
  * Elseif `elseif`
  * Else `else`
* Zapytania na słownikach
  * Select `SELECT`
  * KeyInfo `Key`
  * ValueInfo `Value`
  * FROM `FROM`
  * Where `WHERE`
  * Order `ORDER`
  * By `BY`
  * Ascending `ASC`
  * Descending `DSC`
* Inne
  * Comment `//`
  * MainFunction `main`
  * Class `class`
  * Function `fn`
  * Return `return`
  * Cast `$`
  * Lambda `=>`
  * StringQuote `"`
  * Semicolon `;`
  * Colon `:`
  * Comma `,`
  * Dot `.`
  * Identifier
  * BoolTrueLiteral `True`
  * BoolFalseLiteral = `False`
  * StringLiteral 
  * IntLiteral
  * FloatLiteral
  * Newline
  * EndOfFile

Każdy token w programie musi mieć zdefiniowany swój typ oraz pozycje w pliku (numer linii i kolumna).


**2. Analizator składniowy (Parser)**
<br>Analizator składniowy, nazywany też parserem,
jest kluczowym modułem współpracującym ściśle z analizatorem leksykalnym.
Ten ostatni dostarcza parserowi kolejne tokeny, które są podstawowymi jednostkami leksykalnymi przetwarzanymi przez lekser.

<br>Głównym zadaniem parsera jest sprawdzenie, czy otrzymane tokeny są zgodne ze zdefiniowaną gramatyką języka oraz utworzenie drzewa rozbioru składniowego.
Poprzez analizę drzewa rozbioru składniowego możliwe jest rozpoznawanie zdefiniowanych konstrukcji językowych.
Takie drzewo pozwala na reprezentację tych konstrukcji w sposób zrozumiały dla interpretera lub kompilatora.

**3. Analizator semantyczny i interpreter**
<br>Analizator semantyczny, będący często ostatnim etapem interpretera własnego języka, jest modułem odpowiedzialnym za rozumienie znaczenia wyrażeń zgodnie z regułami semantycznymi języka.
Głównym zadaniem analizatora semantycznego jest przetwarzanie drzewa rozbioru składniowego (parsowanego wcześniej przez parser) i weryfikacja zgodności semantycznej programu.
Analizator semantyczny dokonuje takich czynności jak sprawdzanie typów danych, rozpoznawanie zmiennych, kontrola poprawności wyrażeń oraz wykrywanie błędów semantycznych.

Interpreter ma za zadanie sekwencyjne wykonanie instrukcji zawartych drzewie zbudowanym przez parser

**3. Moduły dodatkowe:**
* Moduł obsługi błędów - odpowiada za identyfikację, zarządzanie i obsługę różnych rodzajów błędów w programie, co często obejmuje zgłaszanie wyjątków, obsługę błędów syntaktycznych i semantycznych. Współpracuje z każdym z głównych modułów programu
* Moduł obslugi plików tekstowych - wspomaga operacje odczytywania zawartości z pliku tekstowego. Współpracuje z analizatorem leksykalnym

## **<br>Sposób testowania:**
Każdy z modułów będzie posiadał testy jednostkowe weryfikujące jego poprawne działanie oraz obsługę wyjątków. Testowanie będzie odbywać się za pomocą biblioteki JUnit<br>
<br> Poniżej przedstawiono kilka przykładów testów, jakie mogą być wykonane, mają one na celu jedynie przedstawienie zamysłu z jakim zostaną zaimplementowane te właściwe.

* **Lekser**
   <br>Testy leksera będą sprawdzać, czy moduł poprawnie przekształca strumień znaków na sekwencję tokenów, co zweryfikuje poprawną analizę leksykalną.  W trakcie testów sprawdzane będą różne przypadki, w tym sytuacje związane z różnymi rodzajami tokenów oraz ewentualne zachowanie wobec błędów leksykalnych.
    ```java
    public class LexerTest {

    @Test
    public void testLexicalAnalysis() {
        Lexer lexer = new Lexer();
        String input = "int x = 10;";
        List<Token> expectedTokens = Arrays.asList(
            new Token(TokenType.Integet, "int"),
            new Token(TokenType.IDENTIFIER, "x"),
            new Token(TokenType.AssignOperator, "="),
            new Token(TokenType.IntegerLiteral, "10"),
            new Token(TokenType.Semicolon, ";")
        );
        List<Token> actualTokens = lexer.analyze(input);
        assertEquals(expectedTokens, actualTokens);
     }
    }
    ```
  
* **Parser**
<br> Tutaj sam zamysł testowania będzie wyglądał podobnie jak w przypadku leksera. Zamiast sekwencji znaków parser dostanie sekwencję tokenów i na jej podstawie będzie generował drzewo składniowe.
   ```java
   public class ParserTest {

       @Test
       public void testSyntaxAnalysis() {
           Parser parser = new Parser();
           List<Token> tokens = Arrays.asList(
               new Token(TokenType.INT_KEYWORD, "int"),
               new Token(TokenType.IDENTIFIER, "x"),
               new Token(TokenType.ASSIGNMENT_OPERATOR, "="),
               new Token(TokenType.INTEGER_LITERAL, "10"),
               new Token(TokenType.SEMICOLON, ";")
           );
           SyntaxTree expectedTree = ... // Zakładając, że mamy zdefiniowane oczekiwane drzewo składniowe
           SyntaxTree actualTree = parser.parse(tokens);
           assertEquals(expectedTree, actualTree);
       }
   }
   ```

* **Analizator semantyczny i interpreter**
<br>Testy jednostkowe mogą obejmować sprawdzanie poprawności wykonania pojedynczych instrukcji,
ewaluację wyrażeń, czy też odpowiednie zachowanie interpretera w różnych scenariuszach.<br><br>

   ```java
      public class SemanticAnalyzerTest {

       @Test
       public void testSemanticAnalysis() {
           SemanticAnalyzer analyzer = new SemanticAnalyzer();
           SyntaxTree tree = ... // Zakładając, że mamy zdefiniowane drzewo składniowe do analizy semantycznej
           assertTrue(analyzer.analyze(tree)); // Sprawdzamy, czy analiza semantyczna jest poprawna, metoda anaylze zwraca true, jeśli tak
       }
   }
   ```
   W przypadku interpretera możemy sprawdzać, czy poprawnie wykonuje on całe programy w różnych przypadkach użycia. Mogą to być testy jednostkowe, które obejmują wykonanie skryptów o złożonej strukturze. Takie testy mogą pełnić rolę testów integracyjnych
