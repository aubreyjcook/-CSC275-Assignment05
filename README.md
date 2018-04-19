# -CSC275-Assignment05
CSC 275 Assignment 5
Instructor: Andrew S. Webb
Question Subject Line: CSC 275 Online Assignment 5 Question
While out on a standard run we stop in at our ‘local’ fence and try to sell some of our items. When we board his ship we notice that we are the only people on board, so we instantly start grabbing things and loading them on our ship and get ready to run. While grabbing things we realize that we are going to run out of space extremely quickly and we should prioritize what we grab to maximize our financial gain while staying under our weight limit.
We don’t have time to figure this out now as Gweedar might come back at any moment and catch us stealing from him – which would result in our instant death.
•	Create an algorithm that maximizes the amount of money we will get if we ever come across this situation again. We will call this method ‘ransack’ and it should accept a large list of items and return the optimal list of items we should grab based on our weight limit.
•	We must store our items in a file and read from the file if prompted by the user. You can create a file with the list of items so you never have to type them in again, and you can control the items that are introduced to our world.
•	Items have attributes such as Name, Weight, Value, Durability and ID. (Create an object called ‘Item’)
•	We now classify our items by separating them into 3 distinct categories Equipable, Consumable or Weapon. (You must implement these 3 classes that are subclasses of Item and they must have at least 3 unique attributes in each subclass)
•	We can carry an unlimited number of items, as long as they don’t exceed the maximum weight of the cargo bay, 25 Tons. (Use an ArrayList that checks an item’s weight before placing it in the cargo hold)
•	The following methods still have the same requirements from the assignment previous to this one: Add, Remove, Search, Sort, Filter, and Display.

Note: With your submission of this assignment you must include all of your files AND your file that you created to load into your program.
