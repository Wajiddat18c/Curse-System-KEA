# Curse-System-KEA
Software Development 3. obligatoriske opgave

		
Til løsning af den obligatoriske opgave har vi valgt anvende følgende patterns:

-MVC pattern: idet vores MainController klasse har til ansvar at opdagere hente dataerne fra databasen, og opdatere viewet. 
Det kan vi f.eks. se ved at controlleren kalder på service klasserne, og derefter mapper til de forskellige hmtl sider, hvor slut-brugeren skal henvises til.
-Factory pattern: kan vi f.eks. se, når vi implementerer vores CRUD interface, og anvender metoder fra interfacet, i repository klasserne. 

Databasen har vi valgt at oprette vha. MySql, og vi har valgt at hoste via. heroku.
