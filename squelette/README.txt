IRAKOZE OLIVE AUDREY
TCHIMOU CHO JOSEE ALVINE

Description du jeu. 
« The binding of Isaac » est un jeu d'action-aventure  programmé en java. Il est composé d’Isaac, le héro et des monstres notamment les araignées, les mouches et le boss. L’aventure se déroule dans des salles <donjon>. 
C'est dans ces salles qu’Isaac y affronte les différents monstres, où il peut ramasser des objets pouvant lui aider ou se heurter sur des objets pouvant lui causer des dommages. 
Pour notre cas, isaac se deplace avec les touches z "  vers le haut", s "vers le bas",q"vers la gauche",d"vers la droite".Aussi il peut tirer des larmes en haut , en bas , à gauche et à droite à l’aide des touches directionnelles.
Nous avons 03 salles : la salle des arraignés , la salle des mouches et la salle du boss.
l’aventure commence dans  salle des arraignée <RoomSpider>. On y trouve Isaac et les arraignée.Pour passer d’une salle a une autre, Isaac doit tuer les monstres. Que ce soit les monstres ou le héros, tous ont une vitesse de déplacement, des points de vie précis qu'ils perdent au fil à mesure qu'ils reçoivent des dommages et ont aussi des nombres de dommage par coup affligé. Pour Isaac, les dommages sont causés par ses larmes qu'ils lancent sous forme de larme.
En luttant avec les différents monstres, si Isaac reçoit des dommages, il perd ses points de vie. Si Isaac n’a plus de point de vie, il est vaincu, le jeu se termine. Et si le monstre ,le boss, n’a plus de point de vie, Isaac a gagné.
Enfin, ce jeu a été programmé en java à partir du squelette qu'on nous avait donné.
 

     Programmes

Dans notre programme nous plusieurs classes .
           
- La classe Main s’occupe de l’initialisation du monde, et de lancer la boucle principale du jeu qui a pour role demettre à jour les entités et de les afficher.
- La classe GameWorld s’occupe de la gestion du monde et de ce qui le compose.
    Dans cettes salles le nombre d'arraignée peut etre modifié ; pour ce faire , il faut juste modifier son constructeur c'est à dire 
                 lors de l'initialisation des salles d'arraignées et de mouches .

-La classe " Projectile "représent une larme d'isaac; les larmes d'isaac sont stockés dans une liste .
- La classe Room représente une piece du donjon , elles contient isaac , la liste de larmes , les différentes fonctions de collisions 
- les classes Roomspider , Roomfly et RoomBoss héritent de la classe Room et elles contientent repectivement la liste des arraignées , des mouches et le boss.


Le project n'est pas terminée : 
    il n'y a pas de salle de magasin , pas de portes , pas d'obstacles , pas de triche .


