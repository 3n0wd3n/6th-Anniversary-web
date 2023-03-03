
import Foundation

/*
 
 Swift je silne staticky typovany jazyk. Lze pouzivat typovou inferenci (odvozeni typu)
 Jazyk Swift obsahuje vsechny zakladni datove typy pro reprezentaci cisel, pravdivostnich hodnot a retezcu.

 Kompletni dokumentace jazyka Swift je na adrese: https://docs.swift.org/swift-book/documentation/the-swift-programming-language/thebasics/
*/

/* DEFINICE PROMENNE */

// Promenna typu Int

var number: Int
var numberWithValue: Int = 10

// Pomoci typove inference
var numberAutomaticType = 10

// Konstanta typu double
let constantNumber = 20.0

// Optionals
//  - Promenne ktere mohou obsahovat nil (obdoba NULL v jazyce C)

var optionalDouble: Double? = 10.33

// Pokud je hodnota optionalDouble rovns nil, tak je vysledek
// volsni rounded take roven nil.
var roundedDown = optionalDouble?.rounded()

// Force unwrap
//  - Ziskame hodnotu kterou obsahuje "box" obalujici optional hodnotu. Pozor v pripade ze je ale hodnota nil -> Fatal error
var unwrappedOptional = optionalDouble!.rounded()

/* STRINGS AND CHARACTERS */
let someString = "Some string literal value"

let quotation = """
The White Rabbit put on his spectacles.  "Where shall I begin,
please your Majesty?" he asked.

"Begin at the beginning," the King said gravely, "and go on
till you come to the end; then stop."
"""

// Vytvoreni prazdneho retezce
var emptyString = ""               // empty string literal
var anotherEmptyString = String()  // initializer syntax

// String Mutability
var variableString = "Horse"
variableString += " and carriage"

let constantString = "Highlander"
constantString += " and another Highlander" // Chyba: Hodnota konstanty nelze menit

/* TISK NA OBRAZOVKU */

// Zakladni tisk ktery vytiskne retezec + znak noveho radku
print("Hello World!!")

// Tisk bez noveho radku
print("Hello World", terminator: "---")

// Formatovany tisk
print("Hodnota roundedDown je \(roundedDown)") // Warning ze ve vypisu bude Optional(...)

// Vyse uvedeny problem se da vyresit pomoci Nil-Coalescing Operator ??
var notNilDoubleValue = roundedDown ?? 0
print("Hodnota roundedDown je \(notNilDoubleValue)")

// Vyse uvedene je syntactic sugar pro ternatni operator

notNilDoubleValue = roundedDown == nil ? 0 : roundedDown!

/* VETVENI PROGRAMU */

if numberWithValue % 2 == 0 {
    print("Hodnota je sude cislo")
} else {
    print("Hodnota je liche cislo")
}

let dayNumber = 24

switch dayNumber {
    
case 23:
    print("Den pred TMAP đźŠ")
    
case 24:
    print("Dnes je TMAP đź‘Ź")
    
case 25:
    print("TMAP je az za tyden đź­")
    
default:
    print("Den o kterem nema smysl se bavit.")
}

/* COLLECTIONS */

// Array

var someInts: [Int] = []
print("someInts is of type [Int] with \(someInts.count) items.")

// Pridani hodnoty ns konec pole
someInts.append(3)

// Pole dane velikosti s konktetni hodnotou
var threeDoubles = Array(repeating: 0.0, count: 3)

// Spojeni 2 poli do jednoho
var anotherThreeDoubles = Array(repeating: 2.5, count: 3)
var sixDoubles = threeDoubles + anotherThreeDoubles


// Set
var favoriteGenres: Set<String> = ["Rock", "Classical", "Hip hop"]

// Insert value into set
favoriteGenres.insert("[Tool J]")

// Odebrani prvku z mnoziny
favoriteGenres.remove("Rock")

// Test jestli mnozina obsahuje hodnotu
favoriteGenres.contains("Funk")

// Operace s mnozinami
let oddDigits: Set = [1, 3, 5, 7, 9]
let evenDigits: Set = [0, 2, 4, 6, 8]
let singleDigitPrimeNumbers: Set = [2, 3, 5, 7]

oddDigits.union(evenDigits).sorted()
// [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
oddDigits.intersection(evenDigits).sorted()
// []
oddDigits.subtracting(singleDigitPrimeNumbers).sorted()
// [1, 9]
oddDigits.symmetricDifference(singleDigitPrimeNumbers).sorted()
// [1, 2, 9]

// Slovniky

var namesOfIntegers: [Int: String] = [:]

// Nastaveni hodnoty
namesOfIntegers[16] = "sixteen"

// Ziskani hodnoty. Pokud hodnota ve slovniku neni vraci nil
let valueFromDictionary = namesOfIntegers[16]


/* LOOPS */

for i in 0..<10 {
    print(i)
}

for i in 0...9 {
    print(i)
}

for value in someInts {
    print(value)
}

var index = 0

while index <= 9 {
    print(index)
    index += 1 // Ve swift nemame ++
}

/* FUNKCE */

func greet(person: String) -> String {
    let greeting = "Hello, " + person + "!"
    return greeting
}

print(greet(person: "Anna"))

func printHelloWorld() {
    print("Hello World!")
}

printHelloWorld()

// Vraceni vice hodnot

func minMax(array: [Int]) -> (min: Int, max: Int) {
    var currentMin = array[0]
    var currentMax = array[0]
    for value in array[1..<array.count] {
        if value < currentMin {
            currentMin = value
        } else if value > currentMax {
            currentMax = value
        }
    }
    return (currentMin, currentMax)
}

// Uprava nazvu parametru

func search(for text: String, in array: [String]) -> String? {
    var result = ""
    
    // ... Count find value
    
    return result
}

let foundString = search(for: "Hello", in: ["Hello", "World"])

// Predani parametru odkazem

func swapTwoInts(_ a: inout Int, _ b: inout Int) {
    let temporaryA = a
    a = b
    b = temporaryA
}

// Anonymni funkce

let lambda: (Int, Int) -> Int = { lhs, rhs in return lhs + rhs }
let add = lambda(10, 20)

var numbers = (0...10).map { number in
    return number
}

// Prehazeni prvku
numbers.shuffle()

// Druha mocnina
numbers = numbers.map { $0 * $0 }

// Sort
numbers.sort { lhs, rhs in
    return lhs < rhs
}

numbers.sort(by: { $0 < $1 })

numbers.sort(by: <)

/* ENUMS */

enum Weather {
    case sunny
    case cloudy(Int)
    case rainy(Int, String)
    case unknown
    
    func getDescription() -> String {
        switch self {
        case .sunny:
            return "It's sunny today."
        case .cloudy(let percent):
            return "It's \(percent)% cloudy today."
        case .rainy(let amount, let type):
            return "It's raining \(amount)mm of \(type) today."
        case .unknown:
            return "The weather is unknown."
        }
    }
}

enum LinkedList<Element> {
    case empty
    indirect case node(Element, next: LinkedList<Element>)
    
    func count() -> Int {
        switch self {
        case .empty:
            return 0
        case .node(_, let next):
            return 1 + next.count()
        }
    }
}

/* STRUCTURE AND CLASSES */

struct Point {
    var x = 0.0
    var y = 0.0
    
    mutating func move(xOffset: Double, yOffset: Double) {
        x += xOffset
        y += yOffset
    }
}

struct Size {
    var width = 0.0
    var height = 0.0
}

class Rect {
    var origin = Point()
    var size = Size()
    
    var center: Point {
        get {
            let centerX = origin.x + (size.width / 2)
            let centerY = origin.y + (size.height / 2)
            return Point(x: centerX, y: centerY)
        }
        set(newCenter) {
            origin.x = newCenter.x - (size.width / 2)
            origin.y = newCenter.y - (size.height / 2)
        }
    }
    
    // Computed properties
    
    var area: Double { return size.height * size.width }
    
    var circuit: Double { 2 * size.width + 2 * size.height }
    
    func move(to point: Point) {
        self.center = point
    }
}

/* Optional chaining */

if let unwrapedValue = optionalDouble {
    // Pracujeme s non-optional hodnotou
} else {
    // Fallback pro pripad ze hodnota je nil
}

// Alternativne
if let optionalDouble {
    // Pracujeme s non-optional hodnotou
} else {
    // Fallback pro pripad ze hodnota je nil
}

//KĂłd v jazyce Swift.
//Autor: ChatGPT, velkĂ˝ jazykovĂ˝ model od OpenAI.
//Datum: 28. Ăşnora 2023.
//DostupnĂ© z: https://github.com/openai/chatgpt

// Definice protokolu
protocol Greeting {
    func sayHello() throws
}

// VĂ˝jimka pro neplatnĂ˝ vÄ›k
enum AgeError: Error {
    case invalidAge
}

// Implementace protokolu tĹ™Ă­dou
class Person: Greeting {
    var name: String
    var age: Int
    private var birthYear: Int
    
    init(name: String, age: Int) throws {
        guard age > 0 else {
            throw AgeError.invalidAge
        }
        self.name = name
        self.age = age
        self.birthYear = try calculateBirthYear()
    }
    
    func sayHello() throws {
        print("Ahoj, jmenuji se \(name).")
    }
    
    private func calculateBirthYear() throws -> Int {
        let currentDate = Date()
        let calendar = Calendar.current
        let currentYear = calendar.component(.year, from: currentDate)
        let birthYear = currentYear - age
        
        guard birthYear > 0 else {
            throw AgeError.invalidAge
        }
        
        return birthYear
    }
}

// Implementace protokolu podtĹ™Ă­dou
class Student: Person {
    var studentID: String
    
    init(name: String, age: Int, studentID: String) throws {
        self.studentID = studentID
        try super.init(name: name, age: age)
    }
    
    override func sayHello() throws {
        print("Ahoj, jmenuji se \(name) a jsem student s ID \(studentID).")
    }
}

// PouĹľitĂ­ tĹ™Ă­dy a podtĹ™Ă­dy
do {
    let person1: Greeting = try Person(name: "Jan", age: 25)
    try person1.sayHello()

    let student1: Greeting = try Student(name: "Petr", age: 20, studentID: "1234")
    try student1.sayHello()
} catch let error {
    print("Chyba: \(error)")
}


// Definice vlastnĂ­ chyby
enum NetworkError: Error {
    case invalidURL
    case noInternetConnection
    case serverError(String)
}

func isInternetConnectionAvailable() -> Bool {
    return Bool.random()
}

// PouĹľitĂ­ vlastnĂ­ chyby
func fetchData(from url: String) throws -> String {
    guard let url = URL(string: url) else {
        throw NetworkError.invalidURL
    }
    
    guard isInternetConnectionAvailable() else {
        throw NetworkError.noInternetConnection
    }
    
    do {
        let data = try Data(contentsOf: url)
        guard let stringData = String(data: data, encoding: .utf8) else {
            throw NetworkError.serverError("Chyba pĹ™i zpracovĂˇnĂ­ dat.")
        }
        return stringData
    } catch {
        throw NetworkError.serverError(error.localizedDescription)
    }
}

// PouĹľitĂ­ funkce
do {
    let data = try fetchData(from: "https://www.example.com/data")
    print(data)
} catch let error as NetworkError {
    switch error {
    case .invalidURL:
        print("Chyba: NeplatnĂˇ URL adresa.")
    case .noInternetConnection:
        print("Chyba: Ĺ˝ĂˇdnĂ© internetovĂ© pĹ™ipojenĂ­.")
    case .serverError(let message):
        print("Chyba serveru: \(message)")
    }
} catch {
    print("NeoÄŤekĂˇvanĂˇ chyba: \(error)")
}

// Singleton
class MySingleton {
    static let shared = MySingleton() // instance singletonu
    
    private init() { // soukromĂ˝ inicializĂˇtor
        // inicializace singletonu
    }
    
    // metody a vlastnosti singletonu
    func doSomething() {
        // metoda
    }
    
    var someProperty: String = "default" {
        didSet {
            // provedenĂ­ akce po zmÄ›nÄ› hodnoty vlastnosti
        }
        
        willSet {
            // provedenĂ­ akce p5ed zmÄ›nou hodnoty vlastnosti
        }
    }
}

// Genericke tridy

class Stack<Element> {
    private var elements: [Element] = []
    
    func push(_ element: Element) {
        elements.append(element)
    }
    
    func pop() -> Element? {
        return elements.popLast()
    }
    
    func count() -> Int {
        return elements.count
    }
    
    func isEmpty() -> Bool {
        return elements.isEmpty
    }
}

// Extension tridy
extension String {
    func trim() -> String {
        return self.trimmingCharacters(in: .whitespacesAndNewlines)
    }
}
