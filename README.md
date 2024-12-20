## 목차

1. [Generic1](#generic1)
   
   - [기존의 문제점](#기존의-문제점)
   - [제네릭의 장점](#제네릭의-장점)
   - [제네릭 선언 방법](#제네릭-선언-방법)
   - [제네릭 생성 방법](#제네릭-생성-방법)
   - [타입 매개변수(T)의 표기법](#타입-매개변수t의-표기법)
   - [용어 정리](#용어-정리)
   - [문제](#문제)
   - [문제 1 풀이](#문제-1-풀이)
   - [문제 2 풀이](#문제-2-풀이)

2. [Generic2](#generic2)
   - [Animal](#animal)
   - [Dog](#dog)
   - [Cat](#cat)
   - [HospitalV0 : 그냥 Dog, Cat 별 따로 클래스를 생성](#hospitalv0--그냥-dog-cat-별-따로-클래스를-생성)
   - [HospitalV1 : 다형성을 이용한 방식](#hospitalv1--다형성을-이용한-방식)
   - [HospitalV2 : 제네릭을 이용한 방식](#hospitalv2--제네릭을-이용한-방식)
   - [HospitalV3 : 타입매개변수 타입 상한 걸기<T extends Animal>](#hospitalv3--타입매개변수-타입-상한-걸기t-extends-animal)
3. [Generic Method](#generic-method)
   - [선언 방식](#선언-방식)
   - [호출 방식](#호출-방식)
   - [타입 매개변수 타입 결정 시점](#타입-매개변수-타입-결정-시점)
   - [문제](#문제-1)
   - [HospitalV4 : 제네릭 메서드 적용](#hospitalv4--제네릭-메서드-적용)
4. [WildCard](#wildcard)  
   - [제네릭 메서드 vs 와일드카드](#제네릭-메서드-vs-와일드카드)      
   - [제네릭메서드를 사용 할 수 밖에 없는 경우](#제네릭메서드를-사용-할-수-밖에-없는-경우)  
   - [상한 와일드카드](#상한-와일드카드)  
   - [하한 와일드카드](#하한-와일드카드)  
   - [문제](#문제)
5. [컬렉션 프레임워크 - ArrayList](#컬렉션-프레임워크---arraylist)
   - [Array 시간복잡도](#array-시간복잡도)
   - [Array의 단점](#array의-단점)
   - [직접 구현하는 ArrayList1 - 시작](#직접-구현하는-arraylist1---시작)
   - [ArrayList 시간 복잡도](#arraylist-시간-복잡도)
6. [컬렉션 프레임워크 - LinkedList](#컬렉션-프레임워크---linkedlist)
    - [LinkedList 시간복잡도(단방향 LinkedList의 경우)](#linkedlist-시간복잡도단방향-linkedlist의-경우)
    - [LinkedList의 장점과 단점](#linkedlist의-장점과-단점)
    - [단방향 LinkedList의 구현](#단방향-linkedlist의-구현)
6. [컬렉션 프레임워크 - List](#컬렉션-프레임워크---list)
    - [리스트 추상화1 - 인터페이스 도입](#리스트-추상화1---인터페이스-도입)
    - [리스트의 추상화](#리스트의-추상화)
    - [전략패턴](#전략패턴)


# Generic1

### 기존의 문제점

- 특정 타입으로 객체를 만드는 경우 : 일일이 각 타입별로 자료형을 만들어야한다.
- Object를 이용하며 다형성과 다운캐스팅을 이용한 경우 : 코드 재사용의 문제는 해결되었지만 타입 안전성 문제가 발생
  - 매개변수로 어떤 자료형도 받을 수 있기 때문에 오류 발생 가능성이 있다.
  - 반환 결과를 받고 다운캐스팅을 사용해야하기 때문에 번거롭다.

### 제네릭의 장점

- 타입 안전성
- 반환 타입의 안전성

### 제네릭 선언 방법

1. 제네릭 클래스(`public class GenericClass<T>`)로 선언
2. 제네릭 클래스 내부에 T(타입 매개변수)를 사용하여 설계한다.

### 제네릭 생성 방법

> 제네릭 클래스는 생성시점에 타입 매개변수가 확정된다. `new GenericClass<Integer>()` (타입 직접 입력 방식)

1. 타입 직접 입력 방식
   
   ```java
   GenericClass<Integer> genericClass = new GenericClass<Integer>();
   ```

2. 타입 추론 방식
   
   ```java
   GenericClass<Integer> genericClass = new GenericClass<>();
   ```

### 타입 매개변수(T)의 표기법

> 기본적으로 대문자로 표기하며 T이외에도 용도에 따라 맞는 단어의 첫 글자를 사용하는 관례를 따른다. 그래서 그냥 대문자 표시된 한글자다? ⇒ 타입 매개변수다.

- T : type
- E : Element
- V : Value
- K : Key
- S, U, V : 2nd, 3rd, 4th types

### 용어 정리

- 제네릭 : “일반적인”, “범용적인” 이라는 뜻으로 타입 상관없이 범용적으로 사용 가능 하게 한다는 의미이세 일맥상통한다.
- 제네릭 타입(Generic Type: `class GenericBox<T>`) : 클래스나 인터페이스를 정의할 떄 타입 매개변수를 사용하는 것을 말함
- 타입 매개변수(Type parameter: `T`) : 제네릭 타입이나 메서드에 사용되는 변수로, 런타임에서 실제 타입으로 대체된다.
- 타입 인자(Type Argument) : 제네릭 타입을 사용할 때 제공되는 실제 타입

### 문제

1. 타입 인자로 원시타입을 사용할 수 있다. 참 거짓

2. 거짓. 타입 인자는 래퍼타입만 가능하다.

# 문제

### 제네릭을 활용해 여러 타입을 value로 받고 출력할 수 있는 GenericClass를 만들고 Integer, String으로 생성 및 value를 출력하시오.

```java
public class practice1 {

        // 제네릭 클래스 생성
        private static class GenericClass<T> {
            private T value;

            public GenericClass(T value) {
                this.value = value;
            }

            public T getValue() {
                return this.value;
            }
        }

    public static void main(String[] args) {

        // 제네릭 생성
        GenericClass<Integer> genericClassInteger1 = new GenericClass<>(1);
        GenericClass<Integer> genericClassInteger2 = new GenericClass<>(2);
        GenericClass<String> genericClassString1 = new GenericClass<String>("hello world!");

        System.out.println(genericClassInteger1.getValue());
        System.out.println(genericClassInteger2.getValue());
        System.out.println(genericClassString1.getValue());
    }
}
```

### 문제 1 풀이

```java
// 제네릭 클래스 생성
private class Container<T> {
    private T item;

    public void setItem(T value) {
        this.item = value;
    }

    public T getItem() {
        return this.item;
    }

    public boolean isEmpty() {
        return item == null;
    }
}
```

### 문제 2 풀이

```java
public class Pair<K, V> {
    private K first;
    private V second;

    public void setFirst(K first) {
        this.first = first;
    }

    public void setSecond(V second) {
        this.second = second;
    }

    public K getFirst() {
        return first;
    }

    public V getSecond() {
        return second;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "first=" + first +
                ", second=" + second +
                "}";
    }
}
```

# Generic2

> 아래의 Animal 부모와 Dog, Cat 자식이 있을때 Hospital Class를 Object를 사용한 방식, 제네릭 타입으로 변경한 방식을 기술하고 장단점을 기술하시오.

### Animal

```java
public class Animal {

    private String name;
    private int size;

    public Animal(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    public void sound() {
        System.out.println("동물 울음 소리");
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", size=" + size +
                '}';
    }
}
```

### Dog

```java
public class Dog extends Animal{
    public Dog(String name, int size) {
        super(name, size);
    }

    @Override
    public void sound() {
        System.out.println("멍멍");
    }
}
```

### Cat

```java
public class Cat extends Animal {
    public Cat(String name, int size) {
        super(name, size);
    }

    @Override
    public void sound() {
        System.out.println("냐옹");
    }
}
```

### HospitalV0 : 그냥 Dog, Cat 별 따로 클래스를 생성

```java
public class DogHospital {

    private Dog animal;

    public void set(Dog animal) {
        this.animal = animal;
    }

    public void checkup() {
        System.out.println("동물 이름: " + animal.getName());
        System.out.println("동물 크기: " + animal.getSize());
        animal.sound();
    }

    public Dog bigger(Dog target) {
        return animal.getSize() > target.getSize() ? animal : target;
    }
}
```

```java
public class CatHospital {

    private Cat animal;

    public void set(Cat animal) {
        this.animal = animal;
    }

    public void checkup() {
        System.out.println("동물 이름: " + animal.getName());
        System.out.println("동물 크기: " + animal.getSize());
        animal.sound();
    }

    public Cat getBigger(Cat target) {
        return animal.getSize() > target.getSize() ? animal : target;
    }
}
```

- 장점: 타입 안전성
- 단점 : 불필요한 코드 중복 발생

### HospitalV1 : 다형성을 이용한 방식

```java
public class HospitalV1 {
        // Dog or Cat type -> Animal
    private Animal animal;

    public void set(Animal animal) {
        this.animal = animal;
    }

    public void checkup() {
        System.out.println("동물 이름: " + animal.getName());
        System.out.println("동물 크기: " + animal.getSize());
        animal.sound();
    }

    public Animal getBigger(Animal target) {
        return animal.getSize() > target.getSize() ? animal : target;
    }
}
```

- 장점 : HospitalV0처럼 Dog용 Cat용을 따로 만들지 않아도 됨

- 단점 : 매개변수로 Cat을 보내야하는데 Dog를 보내는 오류를 범할 수 있다.
  
  ```java
  AnimalHospitalV1 dogHospital = new AnimalHospitalV1();
  AnimalHospitalV1 catHospital = new AnimalHospitalV1();
  
  Cat cat = new Cat("냐옹이1", 300);
  
  // 개병원에 cat 타입을 매개변수로 넣어도 컴파일 오류를 내지 않음
  dogHospital.set(cat);
  ```

### HospitalV2 : 제네릭을 이용한 방식

```java
public class HospitalV2<T> {
    private T animal;

    public void set(T animal) {
        this.animal = animal;
    }

    public void checkup() {
        System.out.println("동물 이름: " + animal.getName());
        System.out.println("동물 크기: " + animal.getSize());
        animal.sound();
    }

    public Animal getBigger(Animal target) {
        return animal.getSize() > target.getSize() ? animal : target;
    }
}
```

- 문제 : 이렇게 짜면 프로그램입장에서 T가 어떤 타입인지 모르기 때문에 Object의 매서드밖에 사용하지 못한다. 그래서 `getName()`, `getSize()` … 와 같은 인스턴스 매서드를 사용하지 못한다. 위의 코드는 컴파일 오류가 발생한다.

### HospitalV3 : 타입매개변수 타입 상한 걸기`<T extends Animal>`

```java
public class HospitalV3<T extends Animal> {
    private T animal;

    public void set(T animal) {
        this.animal = animal;
    }

    public void checkup() {
        System.out.println("동물 이름: " + animal.getName());
        System.out.println("동물 크기: " + animal.getSize());
        animal.sound();
    }

    public T getBigger(T target) {
        return animal.getSize() > target.getSize() ? animal : target;
    }
}
```

- 장점 : 타입 안전성과 코드 중복을 다 잡았다.

# Generic Method

> 제네릭 타입을 클래스 전체가 아닌 특정 메서드 단위로 도입할때 사용되며 해당 매서드 호출 시점에서 매개변수의 타입에 따라 제네릭 타입이 결정되고 호출된다.

### 선언 방식

```java
// 스태틱 메서드
public static <T> T staticGenericMethod(T t){return t}; 
// 인스턴스 메서드
public <T> T instanceGenericMethod(T t){return t};
```

### 호출 방식

```java
Class.<Integer>staticGenericMethod(num);
instance.<Integer>instanceGenericMethod(num);

// 추론 방식
Class.staticGenericMethod(num);
```

### 타입 매개변수 타입 결정 시점

- 제네릭 타입(Class 단위로 제네릭이 선언된 경우) : 객체를 생성하는 시점에 타입 결정
  - `new GenericCalss<Integer>()`
- 제네릭 메서드(메서드 단위로 제네릭이 선언된 경우) : 메서드를 호출하는 시점에서 타입 결정
  - `GenericMethod.<Integer>genericMetod(num)`

### 문제

1. 제네릭 타입에서 제네릭 메서드 선언이 가능하다. 참 거짓

2. `public T genericMethod(T t)` 는 제너릭 메서드이다. 참 거짓

3. 제네릭 타입에서 인스턴스 제네릭 메서드가 정의된경우 타입 매개변수는 어느것이 우선순위일까?

4. 세모
   
   1. static method  : 불가능
   2. instance method : 가능

5. 거짓, 이건 그냥 메서드이다 .다면 타입 매개변수가 선언된 것 뿐이다. 아래에 <T>가 있는게 제네릭 메서드이다.
   
   1. `public <T> T genericMethod(T t)`  

6. 제네릭 메서드가 우선이다. 즉 제네릭 타입이 Integer로 생성되었다 하더라고 인스턴스 메서드가 String으로 호출되었다면 String으로 메서드 관련 작업을 수행한다.

### HospitalV4 : 제네릭 메서드 적용

```java
public class HospitalV4 {

    public static <T extends Animal> void checkup(T animal) {
        System.out.println("동물 이름: " + animal.getName());
        System.out.println("동물 크기: " + animal.getSize());
        animal.sound();
    }

    public static <T extends Animal> T getBigger(T a, T b) {
        return a.getSize() > b.getSize() ? a : b;
    }
}
```

# WildCard

> `*` 와 `?` 기호로 사용되며 타입 인자가 “정해진 제네릭 타입”을 전달 받아 활용할 때 사용한다. 좀더 직관적으로 모든 타입을 받을 수 있는 타입이락 생각하면 된다.

### 제네릭 메서드 vs 와일드카드

- 제네릭 메서드
  
  ```java
  public static <T> void printGenericV1(Box<T> box) {
          System.out.println(box.get());
  };
  ```

- 와일드카드
  
  ```java
  public static void printWildcardV1(Box<?> box) {
          System.out.println(box.get());
  }
  ```

### 제네릭메서드를 사용 할 수 밖에 없는 경우

- 메서드 내에서 타입 매개변수가 사용되는 경우 T를 사용 할 수 밖에 없다.
  
  ```java
  // 제네릭 메서드를 사용 할 수 밖에 없는 경우
  public static <T> T getBoxValue1(Box<T> box) {
      T value = box.get();    // 타입 매개변수 사용
      return value;
  }
  ```
  
  // 이따구로 사용할 수 없다.
  public static ? getBoxValue2(Box<?> box) {
  
      ? value = box.get();
      return value;
  
  }
  
  ```
  
  ```

### 상한 와일드카드

> <? extends Parent>

- ?는 반드시 Parent를 상속한 Child나 Parent이기 때문에 Parent 타입과 Parent에 정의된 메서드를 활용 할 수 있다.

### 하한 와일드카드

> <? super Child>

- ?는 최소 Child 이상 받을 수 있으며 특정 타입과 메서드는 사용 할 수 없다.(사용하려면 Object타입과 메서드를 사용할 수 있다.)

### 문제

1. 위의 제네릭 메서드와 와일드카드를 사용한 메서드에 Box<Dog> box를 매개변수로 입력했을때 어떻게 처리되는지 설명하시오.

2. 와일드 카드는 항상 <>안에서만 정의된다 참 거짓

3. 답
   
   1. 제네릭 메서드 : 컴파일 시점에서 타입 추론에 의해서 T가 Dog로 확정 `<Dog> void method(Box<Dog> box)` 로 컴파일 → 이후 메서드 실행
   2. 와일드카드 메서드 : ?는 그냥 아무 타입이나 다 받을 수 있다는 의미로 제네릭과 관련이 없다. ? = Object를 갈긴것돠 동일하다.

4. 참, ?는 제네릭 타입인 T와 관련된 문법으로 단독으로 사용될 수 없다.



# 컬렉션 프레임워크 - ArrayList

### Array 시간복잡도

- 조회 : O(1)
- 끝자리 삽입 : O(1)
- 중간 삽입 : O(n)
- 끝자리 삭제 : O(1)
- 중간 삭제 : O(n)

### Array의 단점

- 배열의 길이 동적으로 변경 할 수 없기 때문에 너무 크게 생성하면 불필요한 메모리가 낭비되고 너무 작게 생성하면 오류가 발생 할 수 있다.

### 직접 구현하는 ArrayList1 - 시작

- 아래의 조건에 맞게 ArraysListV1를 구현하시오. 단 원소는 Object 자료형이다.
  
  ```markdown
  // 생성자
  1. 기본 생성자, 배열의 크기는 기본 5로 고정
  2. 매개변수로 int를 받는 경우 해당 크기로 배열 생성
  
  // 메서드
  public int size();
  public void add(Object e);
  public Object get(int index);
  public Object set(int index, Object e);
  public int indexOf(Object o);
  @Override
  public void toString();
  ```

- 동적 배열 할당 기능을 추가하여 ArrayListV2를 구현하시오. 제공 기능은 MyArrayListV1과 동일

- 특정 인덱스의 원소를 삭제(remove) 추가(add(index, data)) 기능을 추가하여 MyArrayListV3를 구현하시오.

- 제네릭을 도입하여 MyArrayListV4를 구현하시오.
  
  - 제네릭은 new 키워드에 사용할 수 없다. 그래서 기본적으로 Object[] 을 사용하되 안에 들어가고 나오는 원소의 타입만 타입변수로 관리될 수 있도록 신경써주면된다.

- 주의사항
  
  - 삽입, 삭제시에는 항상 size가 변경된다는 것을 유념하자.

### ArrayList 시간 복잡도

- 기본적으로 Array와 동일하나 삽입시에 새로운 길이의 배열로 갱신될 경우 O(n)이 될 수 있다.

  # 컬렉션 프레임워크 - LinkedList

### LinkedList 시간복잡도(단방향 LinkedList의 경우)

- 조회 : O(1)
- 끝 자라 삽입 : O(n)
- 첫 자리 삽입 : O(1)
- 끝 자리 삭제 : O(n)
- 중간 자리 삭제 : O(n)

### LinkedList의 장점과 단점

- 장점
    - 끝이 아닌 자리의 삽입, 삭제를 빨리하기 위해 사용한다.
- 단점
    - 조회 성능이 좋지않다.

### 단방향 LinkedList의 구현

> 항상 head에 대한 조작인와 3자 노드 prev, next, new or targetNode의 3자 대면을 기억하자.
> 
- Node Class 구현
    
    ```markdown
    // 생성자의 매개변수로 Object item을 받는다.
    // toString();
    ```
    
- Node로 이뤄진 다양한 메서드를 구현하시오.(일단 static method로 구현한다.)
    
    ```markdown
    static void printAll(Node first) : 모든 노드 탐색
    static Node getLastNode(Node first) : 마지막 노드 조회
    static Node getNode(Node first, int index) : 특정 index의 노드 조회
    static void add(Node first, Object item) : 끝 노드에 노드에 데이터 추가
    ```
    
- MyLinkedListV1를 구현하시오, 위의 메서드를 제공해야한다.
    
    ```markdown
    public void add(Object o);
    public Node getLastNode();
    public Object set(int index, Obejct o);
    public Object get(int index);
    private getNode(int index);
    public int indexOf(Object o);
    public int size();
    public string toString();
    ```
    
- MyLinkedListV2를 구현하시오. 추가 메서드 : add(int index, Object o), Node remove(int index)
- MyLinkedListV3를 구현하시오, 제네릭을 적용하시오.

# 컬렉션 프레임워크 - List

> List 자료형은 순서가 있고 중복을 허용하는 자료형으로 구현체로는 ArrayList, LinkedList가 있다.
> 

### 리스트 추상화1 - 인터페이스 도입

- 내가 작성한 MyArrayList와 MyLinkedList의 공통 메서드를 MyList로 만들자
    
    ```java
    // 공통 메서드
    size
    add
    add
    get
    set
    remove
    indexOf
    ```
    
    ```java
    public interface List<T> {   // 동일하게 제네릭으로 선언한다.
    }
    ```
    
- 인터페이스를 정의하는 것 까진 ok 근데 이걸 어떻게 임플시키지?
    
    ```java
    public class MyArrayList<T> implements List<T> {
    }
    ```
    

### 리스트의 추상화

- 아래와 같은 BatchProcess가 있다. 해당 코드를 다형성을 이용해 유지보수가 편한 코드로 변경하고 그 근거를 설명하시오.
    
    ```java
    public class BatchProcessorV1 {
        
        private final MyArrayList<Integer> list = new MyArrayList<>();
        
        public void logic(int size) {
            for(int i = 0; i < size; i++) {
                list.add(0, i);
            }
        }
    }
    ```
    
- 유지 보수를 위한 인터페이스(MyList)에 의존하도록 변경
    
    ```java
    public class BatchProcessorV3 {
        
        // 구현체가 아닌 인터페이스에 의존
        private final MyList<Integer> list;
        
        // 생성자의 매개변수로 구현체를 넣어 언제든 변경 할 수 있다.
        public BatchProcessorV3(MyList<Integer> myList) {
            this.list = myList;
        }
    
        public void logic(int size) {
            for(int i = 0; i < size; i++) {
                list.add(0, i);
            }
        }
    }
    ```
    
    - 인터페이스인 List에 의존하면서 이후 List 인터페이스를 임플 받은 더 좋은 성능을 가진 구현체들을 만들어서 갈아끼워만주면 기존의 메서드를 수정하지 않고 그대로 사용 할 수 있다.
    - 그리고 각 구현체의 고유 기능 사용시에는 해당 구현체인 하위 타입으로 다운캐스팅하여 사용 하면 된다. => 전략패턴
- 각 구현체의 logic 메서드의 성능을 비교하시오.

### 전략패턴

> 객채의 특정 행위를 인터페이스로 정의하고, 이를 구현하는 여러 클래스들을 만들어 동적으로 객체의 행위를 변경할 수 있도록 하는 디자인 패턴
> 
- 위에서 만든 BatchProcessor 처럼 구현체에 의존하는 것이아니라 myList라는 인터페이스에 의존하면서 런타임 시점에서 구현체가 갈아끼워지며 동적으로 객체의 행위를 변경 할 수 있게 되는것이다.
- 컴파일 의존 관계 : 특정 행위가 인터페이스에 의존
- 런타임 의존 관계 : 특정 행위가 실제 구현된 객체에 의존
