## Number Detective 🐧💭🔢


Nach einem stressigen Monat an der PUM haben die Pinguine beschlossen, dass es an der Zeit ist, sich ein wenig zu entspannen und Spaß zu haben. Sie sind auf die Idee gekommen, ein lustiges Zahlenratespiel zu entwickeln, doch sie sind gerade nicht erfahren im Programmieren. Deshalb bitten sie dich um Unterstützung, um das Spiel zu implementieren.


In diesem Spiel hat der Spieler zu Beginn 3 Leben. Ziel des Spiels ist es, eine zufällig generierte Zahl  zu erraten und Punkte sammeln. Der Spieler kann zwischen drei Schwierigkeitsgraden wählen. Je nachdem wird die gesuchte Zahl innerhalb eines bestimmten Bereichs liegen, und er erhält eine festgelegte Anzahl an Versuchen. Der Schwierigkeitsgrad beeinflusst auch, wie viele Punkte und Leben der Spieler für das richtige Raten der Zahl erhält.


<style>
   table th, table td {
       text-align: center;
   }
</style>
<table style="width:400px">
   <tr><th> </th><th>Zahl</th><th>Anzahl Versuche</th><th>Gewinn</th></tr>
   <tr><th>Einfach</th><td>[0;100)</td><td>8</td><td>+200 Punkte</td></tr>
   <tr><th>Mittel</th><td>[0;500)</td><td>10</td><td>+200 Punkte +1 Leben</td></tr>
   <tr><th>Schwer</th><td>[0;1000)</td><td>10</td><td>+500 Punkte +3 Leben</td></tr>
   </table>
<br>
Der Spieler erhält nach jedem Versuch immer Hinweise, ob die gesuchte Zahl höher oder niedriger als seine Eingabe ist. Wenn der Spieler die geheime Zahl nicht innerhalb der verfügbaren Versuche findet, verliert er ein Leben. Wenn der Spieler alle Leben verloren hat, wird das Spiel beendet. <br><br>


### Allgemeine Hinweise
- Um zufällige Zahlen zu generieren, musst du die schon implementierte Klasse `/src/pgdp/RandomNumberGenerator.java` und deren `generate(int upperBound)`-Methode benutzen. Diese Methode nimmt einen Parameter `upperBound` $$ >0 $$ entgegen und generiert eine Zahl im Intervall [0;`upperBound`).
An dieser Klasse darfst du nichts ändern.
- Zum Testen deiner Implementierung kannst du Seeds nutzen. Bei gleichem Seed und gleicher Reihenfolge der Aufrufe sind auch die zurückgegebenen Zufallszahlen identisch. **Den Seed sollst du nur zum Testen verwenden, nicht aber für die finale Abgabe.**
- Zum Einlesen von Nutzereingaben verwende die `readInt()`-Methode aus der Klasse `/src/pgdp/InputReader.java`. Du kannst davon ausgehen, dass der Spieler nur Ganzzahlen eingeben wird.
- Die Verwendung privater Hilfsmethoden und Hilfsvariablen ist erlaubt. Die `guessTheNumber()`-Methode muss aber ohne zusätzliche Aufrufe funktionieren. Außerdem gilt zu beachten, dass die Tests mehrere Methodenaufrufe hintereinander ausführen und statische Hilfsvariablen dazwischen nicht zurückgesetzt werden.
- In der Aufgabenstellung wird in jedem String das Zeichen ⎵ verwendet, um Leerzeichen zu kennzeichnen. Ersetze sie dann später im Code durch ein richtiges Leerzeichen.




### Guess The Number
Deine Aufgabe ist es, die Methode `guessTheNumber()` in der Klasse `/src/pgdp/game/GuessTheNumber.java` zu implementieren.


#### **Spielstart & Ende**
Wenn ein Nutzer das Spiel startet, wird er auf der Konsole mit "<tt style="background-color: #5FB3CE">Hello,⎵Number⎵Detective!</tt>" begrüßt. Anschließend hat er die Möglichkeit, einen Schwierigkeitsgrad auszuwählen. Dazu wird ihm seinen aktuellen Lebens- und Punktestand ("<tt style="background-color: #5FB3CE">You⎵have⎵</tt>\<Lebensstand><tt style="background-color: #5FB3CE">⎵lives⎵and⎵</tt>\<Punktestand><tt style="background-color: #5FB3CE">⎵points.</tt>") angezeigt, gefolgt von einer Liste von möglicher Eingaben:
```
Choose⎵difficulty⎵level⎵to⎵start⎵a⎵new⎵game:
(1)⎵Easy⎵⎵⎵[0;100)⎵⎵⎵8⎵Attempts,⎵Reward:⎵+200⎵Points
(2)⎵Medium⎵[0;500)⎵⎵10⎵Attempts,⎵Reward:⎵+200⎵Points⎵+1⎵Life
(3)⎵Hard⎵⎵⎵[0;1000)⎵10⎵Attempts,⎵Reward:⎵+500⎵Points⎵+3⎵Lives
(4)⎵Exit
```
*Hinweis:* `printMenu()`-Methode!


Gibt der Spieler eine Zahl ein, die nicht zu den möglichen Optionen gehört, wird die Fehlermeldung "<tt style="background-color: #5FB3CE">This⎵was⎵not⎵a⎵valid⎵choice,⎵please⎵try⎵again.</tt>" ausgegeben, und das Programm wartet erneut auf eine Eingabe, bis der Spieler eine gültige Option wählt. Falls der Spieler die vierte Option wählt, um das Spiel zu verlassen, wird auf der Konsole die Nachricht <tt style="background-color: #5FB3CE">Goodbye!</tt> ausgegeben. 
  
Sobald das Spiel endet, entweder durch das Verlassen des Spiels oder durch das Aufbrauchen aller Leben, wird dem Spieler sein finaler Punktestand angezeigt: "<tt style="background-color: #5FB3CE">You⎵are⎵leaving⎵with⎵</tt>\<Punktestand><tt style="background-color: #5FB3CE">⎵points!</tt>"


#### **Spielablauf**
Basierend auf der Auswahl des Schwierigkeitsgrads wird dann eine zufällige Zahl generiert und der Spieler hat eine festgelegte Anzahl an Versuchen, um die Zahl zu erraten. Vor jedem Versuch wird angezeigt, wie vielte der aktuelle Versuch ist: "<tt style="background-color: #5FB3CE">(</tt>\<X><tt style="background-color: #5FB3CE">/</tt>\<Y><tt style="background-color: #5FB3CE">)⎵Enter⎵your⎵guess:</tt>", wobei X die aktuelle Versuchsnummer und Y die maximale Anzahl der Versuche ist. Dann wird eine Eingabe vom Spieler erwartet. Nach jeder Eingabe erfährt der Spieler, ob die gesuchte Zahl höher ("<tt style="background-color: #5FB3CE">The⎵number⎵is⎵higher.</tt>") oder niedriger ("<tt style="background-color: #5FB3CE">The⎵number⎵is⎵lower.</tt>") als seine Eingabe ist.


Wenn der Spieler die richtige Zahl errät, wird die Runde mit der Erfolgsmeldung "<tt style="background-color: #5FB3CE">Congrats!⎵You⎵guessed⎵the⎵correct⎵number.</tt>" abgeschlossen, und er erhält die entsprechenden Preise. Sollte der Spieler alle Versuche aufgebraucht haben, ohne die richtige Zahl zu erraten, wird die gesuchte Zahl angezeigt ("<tt style="background-color: #5FB3CE">Sorry,⎵you've⎵used⎵all⎵attempts.⎵The⎵correct⎵number⎵was⎵</tt>\<gesuchte Zahl><tt style="background-color: #5FB3CE">.</tt>") und er verliert ein Leben. Falls der Spieler keine Leben mehr hat, wird er mit der Nachricht "<tt style="background-color: #5FB3CE">Game⎵over!⎵You⎵are⎵out⎵of⎵lives.</tt>" darüber informiert, dass das Spiel beendet ist.


Hat der Spieler jedoch noch Leben übrig, wird ihm sein aktueller Punktestand und Lebensstand angezeigt, gefolgt vom Menü, damit er einen neuen Schwierigkeitsgrad auswählen kann, um eine neue Runde zu starten.


#### Hinweis
Sollte der Spieler im letzten Versuch angekommen sein, hat er, sofern er genügend Punkte hat, die Möglichkeit, für 600 Punkte einen speziellen Hinweis zu kaufen, der ihm verrät, ob die gesuchte Zahl gerade oder ungerade ist. Vor dem letzten Versuch wird der Spieler gefragt: "<tt style="background-color: #5FB3CE">LAST⎵ATTEMPT!⎵Do⎵you⎵want⎵to⎵buy⎵a⎵hint⎵for⎵600⎵points?⎵(1)⎵yes⎵(2)⎵no</tt>". Sollte der Spieler eine andere Eingabe machen, wird ihm die Fehlermeldung "<tt style="background-color: #5FB3CE">This⎵was⎵not⎵a⎵valid⎵choice,⎵please⎵try⎵again.</tt>" angezeigt, und das Programm wartet auf eine gültige Eingabe. Wenn der Spieler den Hinweis kauft, wird eine der folgenden Meldungen ausgegeben: "<tt style="background-color: #5FB3CE">The⎵number⎵is⎵even!</tt>" oder "<tt style="background-color: #5FB3CE">The⎵number⎵is⎵odd!</tt>". Dann wird der Spieler aufgefordert, seine letzte Schätzung abzugeben.


###### **Beispiel**
<details>
<summary>  Beispiel mit Seed 1304 (zum Ausklappen hier klicken)</summary>
<pre>
Hello, Number Detective!
You have 3 lives and 0 points.
Choose difficulty level to start a new game:
(1) Easy   [0;100)   8 Attempts, Reward: +200 Points
(2) Medium [0;500)  10 Attempts, Reward: +200 Points +1 Life
(3) Hard   [0;1000) 10 Attempts, Reward: +500 Points +3 Lives
(4) Exit
5
This was not a valid choice, please try again.
1
(1/8) Enter your guess:
50
The number is higher.
(2/8) Enter your guess:
75
The number is higher.
(3/8) Enter your guess:
77
Congrats! You guessed the correct number.
You have 3 lives and 200 points.
Choose difficulty level to start a new game:
(1) Easy   [0;100)   8 Attempts, Reward: +200 Points
(2) Medium [0;500)  10 Attempts, Reward: +200 Points +1 Life
(3) Hard   [0;1000) 10 Attempts, Reward: +500 Points +3 Lives
(4) Exit
2
(1/10) Enter your guess:
250
The number is higher.
(2/10) Enter your guess:
472
Congrats! You guessed the correct number.
You have 4 lives and 400 points.
Choose difficulty level to start a new game:
(1) Easy   [0;100)   8 Attempts, Reward: +200 Points
(2) Medium [0;500)  10 Attempts, Reward: +200 Points +1 Life
(3) Hard   [0;1000) 10 Attempts, Reward: +500 Points +3 Lives
(4) Exit
3
(1/10) Enter your guess:
585
Congrats! You guessed the correct number.
You have 7 lives and 900 points.
Choose difficulty level to start a new game:
(1) Easy   [0;100)   8 Attempts, Reward: +200 Points
(2) Medium [0;500)  10 Attempts, Reward: +200 Points +1 Life
(3) Hard   [0;1000) 10 Attempts, Reward: +500 Points +3 Lives
(4) Exit
1
(1/8) Enter your guess:
50
The number is lower.
(2/8) Enter your guess:
5
The number is higher.
(3/8) Enter your guess:
30
The number is lower.
(4/8) Enter your guess:
20
The number is lower.
(5/8) Enter your guess:
7
The number is higher.
(6/8) Enter your guess:
8723
The number is lower.
(7/8) Enter your guess:
-5
The number is higher.
LAST ATTEMPT! Do you want to buy a hint for 600 points? (1) yes (2) no
1
The number is even!
(8/8) Enter your guess:
10
Sorry, you've used all attempts. The correct number was 14.
You have 6 lives and 300 points.
Choose difficulty level to start a new game:
(1) Easy   [0;100)   8 Attempts, Reward: +200 Points
(2) Medium [0;500)  10 Attempts, Reward: +200 Points +1 Life
(3) Hard   [0;1000) 10 Attempts, Reward: +500 Points +3 Lives
(4) Exit
4
Goodbye!
You are leaving with 300 points!
</pre>
</details>
<br>

#### **Games**
Nun wird alles zusammengetestet. Diese Tests simulieren vollständige Spielsitzungen. Um diese Tests zu bestehen, müssen alle Teile des Spiels korrekt zusammenarbeiten. Vergiss nicht: Du kannst deine Implementierung testen, indem du die main-Methode ausführst. So kannst du eventuelle Probleme in deiner Implementierung einfach beim Spielen des Spiels entdecken!
