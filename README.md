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
> 
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
> 
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

1. 거짓. 타입 인자는 래퍼타입만 가능하다.

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
> 

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