
school_Managemenet

UML Domian Design possible flaws

An address can belong to many students (Domain model shows one to one relationship)
Bridgin entities are easier to us with identifiers (UML implements aggregation with classes as attributes instead of using identifiers which are easier to manage)
All attributes have public access modifiers, to strengthen data integraty identifiers(keys) should be protected or private
There is a missing multiplicity between NAME and STUDENT
NAME nad ADDRESS should should incorporate identifies eg id primary keys amking it easier to link to other Entities.

Implementation of the system possible flaws.

System does not contain API packages, this would take all the work from the controller and put it in api reducing the boiler plant code in controller classes
A better use of data structures for storring data in memory could increase runtime
Our system is not independenly deployable because its only a section of the Problem statment
Could use less value objects as it is harder to manage in a relational database
Data type types shouold be more secure to protect data from being manipulate where it shouldnt be muttable.






