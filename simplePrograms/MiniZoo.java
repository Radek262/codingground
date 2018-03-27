/*
 * Nazwa: MiniZoo.java
   
Autor: Radosław Dunin-Wąsowicz  (c) 2016
   
Album: 192663
   Grupa: KrDZIs2012
   
Opis: 
    Program obrazuje zoo zawierajace liste pewnych zwierzat 3 typow Panda,Kucyk,Malpa.
    W kazdej chwili mozliwe jest dodanie nowego zwierzaka, nawet jesli nie jest on zadnym z ww typow.
    Program zawiera metody: karmienia, dodawania nowego zwierzaka, zliczania zwierzat, wywolania ich listy
    z informacjami o nich. Metody te mozna wywolac w kazdej chwili podajac odpowiednie parametry.
    Do programu wykorzystanu polimorfizm, dziedziczenie oraz tabliceListowe.
   
Kompilacja: javac Minizoo.java
    
Uruchomienie: java MiniZoo
 */
import java.util.ArrayList;				// importowanie potrzebnych klas
import java.util.Iterator;


class Animal
{
	String name,type;					// definicja potrzebnych zmiennych
	int old;
		public Animal(String name,String type, int old) 			//konstruktor zwierzakow
		{
			this.name=name;
			this.type=type;
			this.old=old;	
		}	
		public String name(Animal a)				//metoda zwracajaca imie zwierzaka
		{
			return name;

		}
		
		public  void inf(Animal a)					// metoda zwracajace informacje o zwierzaczkach
		{
			System.out.printf("name: %s, old: %d month, type: %s \n",name,old,type );

		}
}
	
class Panda extends Animal							//definicja kolejncy klas zwierzakow, rozszerzonych o klase Animal													
{
	public Panda(String name,String type,int old) 
	{
		super(name,type,old);						//wywolanie konstruktora nad klasy
	}
	
}	
class Pony extends Animal
{
	public Pony(String name,String type,int old)
	{
		super(name,type,old);
	}
		
}

class Monkey extends Animal
{
	public Monkey(String name,String type,int old)
	{
		super(name,type,old);
	}
	
}

class KornelsZoo												//klasa "obslugujaca" zoo
{	public static void counter(ArrayList animals){							//metoda zlicza ilosc zwierzat w zoo
		System.out.println("In zoo we have "+animals.size()+" animals");
}

	public static void feedingTime(String name,ArrayList <Animal> animals)		//metoda karmienia pupili
	{
		if(name.equalsIgnoreCase("all"))										// karmimy wszystkie
				{
					for(int i=0;i<animals.size();i++)
					{
						String nameA = animals.get(i).name(animals.get(i));
						System.out.println(nameA+" is feeding");
					}
				}
		else																	// karmimy tylko jedno wybrane
			{
				for(int j=0;j<animals.size();j++)
				{
					if(name.equalsIgnoreCase(animals.get(j).name(animals.get(j))))
					{
						System.out.println(name+" is feeding");
					}
				}
			}
	}

	public static void newAnimal(String type,String name,int old, ArrayList <Animal> animals)		// dodajemy zwierzaczka
	{
		switch(type)
		{
			case ("Panda"):						// kolejne typy zwierzakow w zaleznosci od klasy obiektu, polimorfizm
			{
				animals.add(new Panda(name,type,old));			// dodaj nowe zwierzaka do listy
				System.out.println("We have new animal, welcome "+name+" in our happy family");
			}
				break;
			
			case ("Pony"):
			{
				animals.add(new Pony(name,type,old));
				System.out.println("We have new animal, welcome "+name+" in our happy family");
			}
				break;
		
			case ("Monkey"):
			{
				animals.add(new Monkey(name,type,old));
				System.out.println("We have new animal, welcome "+name+" in our happy family");
			}
				break;
			default:														// co zrobic gdyby nie bylo takiego gatunku pupila	
			{
				animals.add(new Animal(name,type,old));
				System.out.println("We have new animal, welcome "+name+" in our happy family");
			}
				break;
		}
	}
	
	public static void listOfAnimals(ArrayList <Animal> animals)			// generacja listy zwierzakow w zoo
	{
		for(int i=0;i<animals.size();i++)
		{
			animals.get(i).inf(animals.get(i));

		}
	}
	
}
public class MiniZoo
	{
		public static void main(String[] args)
		{
			

			ArrayList<Animal> animals = new ArrayList<Animal>();		//definicja listy zwierzakow
			
			animals.add(new Panda ("Teo","Panda",36));
			animals.add(new Panda("Piki","Panda",5));
			animals.add(new Panda("Miki","Panda",5));
			animals.add(new Panda("Romi","Monkey",48));
			animals.add(new Panda("Tysia","Monkey",48));
			animals.add(new Panda("Gatek","Pony",24));
			animals.add(new Panda("Kajtek","Pony",36));
			animals.add(new Panda("Taksel","Pony",60));

			KornelsZoo.counter(animals);					//wywolanie metody zliczajacej elementy listy(zwierzeta)
			
			KornelsZoo.listOfAnimals(animals);				// wywolanie metody podajace liste zoo
			
			KornelsZoo.feedingTime("Teo",animals);			// wywolanie metody karmienia
			
			KornelsZoo.newAnimal("Panda", "Pikus", 1, animals); //wywolanie metody nowego zwierzaka, w razie narodzin lub
																//przyjecie nowego, nazwy typow musza byc pisane z duzej litery.
			
			//KornelsZoo.listOfAnimals(animals);					// Sprawdzenie nowej listy zwierzakow po dodaniu 
			
		}

	}



