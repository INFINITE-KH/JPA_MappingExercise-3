OPG 4
Vi har oprettet tre nye entities.
Den første er ”DiscountType”. Denne er en abstrakt klasse, der indeholder den abstrakte (og derfor tomme) metode ”calcDiscount”. Denne virker altså som en skabelon til alle klasse, der er en type af discount.
De to andre klasser ”DiscountFixed” og ”DiscountQuantity” er så entities, der inheriter fra ”DiscountType”. Dette gøres i java ved at benytte ”extend” tagget. De har altså alle abstrakte metoder fra ”DiscountType”, som i dette tilfælde er den enkelte metode ”calcDiscount”. De har hver deres egen implementation af metoden.

I databasen får vi dog kun en tabel, der er navngivet ”DiscountType”. Denne indeholder følgende felter:
ID: Dette er blot en unique identifier.
DTYPE: Dette er det felt der illusterer hvilken af de to entities af DiscountType vi har oprettet, altså enten DiscountFixed eller DiscountQuantity. Dvs. at alle entities af DiscountFixed og DiscountQuantity bliver sat ind i tabellen for DiscountType.
DISCOUNT: Mængden af discount der bliver givet (fx 200 kr)
QUANTITYFORDISCOUNT: Mængden der skal købes for at få discount.

OPG 5
Forskellen fra tabelstrukturen i databasen fra denne opgave, og opgave 4 er, at hver entity nu har sin egen tabel. Så instanser af DiscountFixed og DiscountQuantity bliver nu gemt i deres egen tabel. DiscountType er nu blot en joint af de to, hvor deres id, og deres type (DTYPE) er joined i en tabel. 

Der er fordele og ulemper ved begge tabelstrukturer. I visse tilfælde ville det give mening at have en tabel, der indeholder alt dataen, såfremt at dataen der skal tilgås, ikke er interesant isoleret. Har man dog behov for fx at hente alle faste discounts og vise til en kunde eller lign. er det en god ide at have dem i hver deres tabel, og samtidig have en joint tabel for når samtlige discounts skal tilgås.
