-- phpMyAdmin SQL Dump
-- version 4.4.13.1deb1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 28-06-2016 a las 00:10:20
-- Versión del servidor: 5.6.30-0ubuntu0.15.10.1
-- Versión de PHP: 5.6.11-1ubuntu3.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `enigma`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `preguntajuego2`
--

CREATE TABLE IF NOT EXISTS `preguntajuego2` (
  `id` int(11) NOT NULL,
  `pregunta` varchar(100) NOT NULL,
  `respuesta` varchar(100) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `preguntajuego2`
--

INSERT INTO `preguntajuego2` (`id`, `pregunta`, `respuesta`) VALUES
(1, '¿Cuál es el continente más pequeño del mundo?', 'oceanía'),
(2, '¿Cuál es el volcán más activo del mundo?', 'kilahuea'),
(3, '¿Cómo se llama nuestra galaxia?', 'vía láctea'),
(4, '¿Qué es la aurora boreal?', 'un fenómeno visual'),
(5, '¿Cuál es el río más largo del mundo?', 'nilo'),
(6, '¿A qué país pertenecen las islas galápagos?', 'ecuador'),
(7, '¿Cuál es la parte de las plantas responsable de absorber el agua?', 'raíz'),
(8, '¿Mediante que órgano respiran los peces?', 'branquias'),
(9, '¿Cuántos huesos tiene el sistema óseo?', '206'),
(10, '¿Cuántos lados tiene un  decágono?', '10'),
(11, '¿Con que letra se designa el número 50 en los números Romanos?', 'L'),
(12, '¿Cuántas caras tiene un icosaedro?', '20'),
(13, '¿Cuál es la cuarta dimensión?', 'tiempo'),
(14, '¿Cuántos viajes realizo Cristóbal Colon?', '4'),
(15, '¿A qué país se le conoce como el país de los mil lagos?', 'canada'),
(16, '¿Qué nombre se le da al hielo que flota en el mar?', 'iceberg'),
(17, '¿Cuántos grados  comprende la escala Richter?', '10'),
(18, '¿Cuál es el planeta más brillante del sistema solar?', 'venus'),
(19, '¿Qué planeta del sistema solar tiene la mayor cantidad de lunas?', 'saturno'),
(20, '¿Cada cuántos años es visible el cometa Halley?', '76'),
(21, '¿Cuánto tiempo se tarda la luz del sol en llegar a la tierra?', '8 minutos'),
(22, '¿Cuál es el mineral más escaso en la corteza terrestre?', 'mercurio'),
(23, '¿Cómo se llamó el caballo de Simón Bolívar?', 'palomo'),
(24, '¿Con que otro nombre se conoce al leopardo negro?', 'pantera'),
(25, '¿Cuál es la primera letra del alfabeto Griego?', 'alfa'),
(26, '¿Cuál es el mamífero que no tiene cuerdas vocales (es mudo)?', 'jirafa'),
(27, '¿Cómo se llama la cría del conejo?', 'gazapo'),
(28, '¿Con que bebida mataron a Sócrates?', 'cicuta'),
(29, '¿Cuántos corazones tiene un pulpo?', '3'),
(30, '¿Cómo se llama la cría del oso?', 'osezno');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `preguntajuego3`
--

CREATE TABLE IF NOT EXISTS `preguntajuego3` (
  `id` int(11) NOT NULL,
  `pregunta` varchar(100) NOT NULL,
  `respuesta` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `preguntajuego3`
--

INSERT INTO `preguntajuego3` (`id`, `pregunta`, `respuesta`) VALUES
(1, '¿Cuántos dedos tiene en total un elefante africano?', 14),
(2, '¿En que año llegó el primer automóvil a Venezuela?', 1904),
(3, '¿En que año fue fundada la FIFA?', 1904),
(4, '¿En qué año se abolió la esclavitud en Venezuela?', 1854),
(5, '¿Alrededor de cuantas islas componen a Japón?', 4000),
(6, '¿En qué año fue inventado el clip?', 1900),
(7, '¿Cuántos años puede vivir el frailejón?', 150),
(8, '¿Cuántos años paso en prisión Nelson Mandela?', 27),
(9, '¿En qué año se fundó la empresa Microsoft?', 1975),
(10, '¿Cuántos  eran los hermanos Lumiére?', 2),
(11, '¿Cuándo se inicia el proceso de apertura petrolera en Venezuela?', 1992),
(12, '¿Cuántos dedos tienen los caballos en sus patas?', 1),
(13, '¿En qué año muere Juan Félix Sánchez, “el artista del páramo”?', 1997),
(14, '¿En qué año se fundó la ciudad de Mérida?', 1558),
(15, '¿Cuántos agujeros o troneras tienen una mesa de pool?', 6),
(16, '¿Cuántos cayos e islas conforman el parque nacional Los Roques?', 58),
(17, '¿En qué año ocurrió el desastre nuclear de Chernóbil?', 1980),
(18, '¿Cuántas vertebras componen la espina dorsal de los humanos?', 33),
(19, '¿Cuántos jugadores de baloncesto están en la cancha durante un juego?', 5),
(20, '¿Cuántos jugadores conforman un equipo de beisbol en cancha?', 9),
(21, '¿Cuántas veces fue Pelé campeón del mundo con la selección Brasileña?', 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `preguntajuego4`
--

CREATE TABLE IF NOT EXISTS `preguntajuego4` (
  `id` int(11) NOT NULL,
  `pregunta` varchar(100) NOT NULL,
  `opcion1` varchar(20) NOT NULL,
  `opcion2` varchar(20) NOT NULL,
  `opcion3` varchar(20) NOT NULL,
  `opcion4` varchar(20) NOT NULL,
  `respuesta` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `preguntajuego4`
--

INSERT INTO `preguntajuego4` (`id`, `pregunta`, `opcion1`, `opcion2`, `opcion3`, `opcion4`, `respuesta`) VALUES
(1, '¿Qué es un gavial?', 'Halcón Africano', 'Cocodrilo Asiático', 'Pez Abisal', 'Sapo Gigante', 2),
(2, '¿Cómo se llama la luna de plutón?', 'Caronte', 'Tetis', 'IO', 'Titania', 1),
(3, '¿En que atolón se probo la bomba H?', 'Muroroa', 'Eniwetok', 'Ross', 'Bikini', 2),
(4, '¿En dónde se desarrolló la Bomba Atómica?', 'Syracuse, Nueva york', 'Pasadena, California', 'Boston, Massachusett', 'Los álamos, nuevo Mé', 4),
(5, '¿Qué es una Marsopa?', 'Un cetáceo', 'Un roedor', 'Un marsupial', 'Un Primate', 1),
(6, '¿Cuál es el primate más pequeño del mundo?', 'El Gibón', 'El mono aullador', 'El lémur', 'El mono ardilla', 3),
(7, '¿Cómo se llama el cruce entre asno y yegua?', 'Andrógino', 'Mula', 'Centauro', 'Minotauro', 2),
(8, '¿Cómo se llaman a los pocos peces que pueden respirar tanto dentro como fuera del agua?', 'Dipneos', 'Lampreas', 'Mixinos', 'Ungulados', 1),
(9, '¿Qué dios egipcio es el soberano del reino de los muertos?', 'Osiris', 'Karion', 'Kheops', 'Micerinos', 1),
(10, '¿A que debe su nombre el pájaro “Cristofué”?', 'Su canto', 'Su color', 'Su actitud', 'Su velocidad', 1),
(11, '¿Por qué vicio se deja arrastrar un heliogábalo?', 'Gula', 'Avaricia', 'Pereza', 'Envidia', 1),
(12, '¿Cómo se le dice a la cría del pato? ', 'Gansarón', 'Avelino', 'Murgón', 'Anadino', 4),
(13, '¿En qué ciudad Venezolana queda el castillo de Santa Rosa?', 'La Asunción', 'San Carlos del Zulia', 'La Guaira', 'Puerto Cabello', 1),
(14, '¿Cómo se llamó la 1era bomba atómica?', 'Little John', 'Cotton Candy', 'Little boy', 'Chitty chitty bum bu', 3),
(15, '¿A base de que esta hecho el sake?', 'Maíz', 'Gingseng', 'Arroz', 'Plátano', 3),
(16, '¿Cuál de estos animales no pertenece al horóscopo Chino?', 'Tigre', 'Liebre', 'Mono', 'Elefante', 4),
(17, '¿En qué estado queda la represa de Agua Viva?', 'Táchira', 'Falcón', 'Trujillo', 'Mérida', 3),
(18, '¿Cuál es el hueso más largo del cuerpo?', 'Falange', 'Fémur', 'Húmero', 'Esternón', 2),
(19, '¿Quien escribió el célebre poema Venezolano “La loca Luz Caraballo”?', 'Andrés Bello', 'Andrés Eloy Blanco', 'Aquiles Nasoa', 'Rómulo Gallegos', 2),
(20, '¿Qué es un Nenúfar?', 'Una ninfa pequeña', 'Una musa marina', 'Una planta acuática', 'Un árbol antiguo', 3),
(21, '¿Cómo se llama el gorro de los toreros?', 'Mitra', 'Pasamontallas', 'Montera', 'Capirote', 3),
(22, '¿Qué instrumento se usa para medir la presión atmosférica?', 'Termómetro', 'Barómetro', 'Multímetro', 'Voltímetro', 2),
(23, '¿Qué tipo de animal es una galápago?', 'Ave', 'Pez', 'Tortuga', 'Cocodrilo', 3),
(24, '¿Qué nombre reciben los mamíferos que alcanzan la madures en una bolsa y no en el útero?', 'Roedores', 'Félidos', 'Marsupiales', 'Primates', 3),
(25, '¿Qué personaje de la literatura confundió molinos de vientos con gigantes?', 'Don Quijote', 'Calígula', 'Mao', 'Julio Cesar', 1),
(26, '¿de quién es la frase celebre “divide y reinaras”?', 'Mariano Moreno', 'Maquiavelo', 'Alfred hitchcock', 'Bill Clinton', 2),
(27, '¿Cómo se le dice técnicamente al cachorro del lobo?', 'Lobito', 'Lóbulo', 'Lobato', 'Novato', 3),
(28, '¿Cuál es el hueso que forma pareja con el peroné?', 'El cubito', 'El radio', 'El fémur', 'La tibia', 4),
(29, '¿En la multiplicación cual es el elemento neutro?', '0', '2', 'No hay', '1', 4),
(30, '¿Qué árbol aparece en “el Principito”', 'Eucalipto', 'Secuoya', 'Baobab', 'Manzano', 3),
(31, '¿Qué es la babosa?', 'Un artrópodo', 'Un insecto', 'Un molusco', 'Un cetáceo', 3),
(32, '¿Cómo se llama al sonido que emiten los patos?', 'Cacareo', 'Canto', 'Graznido', 'Chismorreo', 3),
(33, '¿Cómo se llaman los animales que pueden vivir tanto dentro como fuera del agua?', 'Reptiles', 'Anfibios', 'Bipolares', 'Ovíparos', 2),
(34, '¿Dónde se produjo la llamada revolución de los claveles?', 'Chile', 'Portugal', 'China', 'India', 2),
(35, '¿Cómo se denomina la cría de organismos acuáticos en entornos de agua salada o dulce?', 'Piscicultura', 'Avicultura', 'Agricultura', 'Acuacultura', 1),
(36, '¿Con que otro nombre se conoce a la nutria en Venezuela?', 'Perro de agua', 'Caribito', 'Curaraque', 'Pijotero', 1),
(37, '¿Cuál es la frontera más larga del mundo?', 'Rusia-China', 'Kazajistán-Rusia', 'U.S.A.-México', 'Canadá-U.S.A.', 4),
(38, '¿Qué país administra la Isla de pascua?', 'U.S.A.', 'Nueva Zelanda', 'Chile', 'Australia', 3),
(39, '¿Qué es la halterofilia?', 'Una enfermedad', 'Una carrera de cabal', 'Fobia a los Gatos', 'Levantamiento de pes', 4),
(40, 'En matemáticas, diez milímetros son un…', 'Centímetro', 'Metro', 'Decímetro', 'Poquito', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `preguntajuego5`
--

CREATE TABLE IF NOT EXISTS `preguntajuego5` (
  `id` int(11) NOT NULL,
  `opcion1` varchar(20) NOT NULL,
  `opcion2` varchar(20) NOT NULL,
  `opcion3` varchar(20) NOT NULL,
  `opcion4` varchar(20) NOT NULL,
  `opcion5` varchar(20) NOT NULL,
  `opcion6` varchar(20) NOT NULL,
  `pista1` varchar(100) NOT NULL,
  `pista2` varchar(100) NOT NULL,
  `pista3` varchar(100) NOT NULL,
  `pista4` varchar(100) NOT NULL,
  `pista5` varchar(100) NOT NULL,
  `pista6` varchar(100) NOT NULL,
  `respuesta1` int(11) NOT NULL,
  `respuesta2` int(11) NOT NULL,
  `respuesta3` int(11) NOT NULL,
  `respuesta4` int(11) NOT NULL,
  `respuesta5` int(11) NOT NULL,
  `respuesta6` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `preguntajuego5`
--

INSERT INTO `preguntajuego5` (`id`, `opcion1`, `opcion2`, `opcion3`, `opcion4`, `opcion5`, `opcion6`, `pista1`, `pista2`, `pista3`, `pista4`, `pista5`, `pista6`, `respuesta1`, `respuesta2`, `respuesta3`, `respuesta4`, `respuesta5`, `respuesta6`) VALUES
(1, 'Cerdo', 'Oveja', 'Vaca', 'Pato', 'Perro', 'Gato', 'Puede subir pero no bajar por una escalera', 'Para este animal es físicamente imposible mirar el cielo', 'Este animal solo bebe agua que no esté en movimiento', 'Tiene como antepasado al lobo', 'El sonido que hace no produce eco', 'Sus bigotes sirven para orientarse en la oscuridad', 3, 1, 2, 5, 4, 6),
(2, 'Avestruz', 'Koala', 'Jirafa', 'Elefante', 'León', 'Cocodrilo', 'Su ojo es más grande que su cerebro', 'Duerme 22 horas al día', 'Es el único mamífero que no tiene cuerdas vocales', 'Es el animal terrestre más grande', 'Es el animal de mayor actividad reproductiva del mundo', 'Puede correr tan rápido como un caballo', 1, 2, 3, 4, 5, 6),
(3, 'Halcón Peregrino', 'Ballena Azul', 'Tiburón Ballena', 'Abejas', 'Estrella de Mar', 'hámster', 'Sus latidos cardiacos pueden ser de 250 a 500 por minuto', 'No tiene cerebro', 'Nacen con el mismo tamaño que tienen a lo largo de su vida', 'Tiene más de 4500 dientes', 'Puede llegar a pesar 180 toneladas', 'Puede alcanzar los 340 km/horas', 6, 5, 4, 3, 2, 1),
(4, 'Caracol', 'Canguro Rojo', 'Mosca', 'Murciélago', 'libélula', 'Orugas', 'Tarda una hora en caminar medio metro', 'Tiene 400 músculos', 'Puede dar un salto de hasta 12 metros', 'Solo vive un día', 'Tiene más de 400 ojos simples', 'Es el único mamífero que vuela', 1, 6, 2, 5, 3, 4),
(5, 'Manzanas', 'Bananas', 'Fresa', 'Patilla', 'Mango', 'Kiwi', 'Contiene el doble de vitamina C de la que posee una naranja', 'Flotan en el agua porque están constituidas en un 25% por aire', 'Es la única fruta que tiene las semillas en su exterior y, ¡puede llegar a tener hasta 200!', 'Sus cascaras eran utilizadas para transportar agua durante expediciones largas', 'Es la fruta más elegida del mundo', 'Una vez ingeridas tienen un efecto antiácido natural', 6, 1, 3, 4, 5, 2),
(6, 'Limón', 'Aguacate', 'Higos', 'Ciruela', 'Granada', 'Uva', 'Representa un excelente desinfectante natural', 'Aporta fibra y gran cantidad de vitaminas, También es buena para la piel', 'Se trata de una fruta baja en calorías y con poca grasa. Es buena para las enfermedades cardíacas', 'Se cultiva en todos los continentes de la tierra', 'Media taza contiene tanto calcio como media taza de leche', 'Varios estudios han demostrado que es la fruta más nutritiva del mundo', 1, 6, 5, 4, 3, 2),
(7, 'Cucaracha', 'Camello', 'Mosquito', 'Cocodrilo', 'Pez Vela', 'Jirafa', 'Duerme tan solo 7 minutos por día y lo hace de pie', 'puede alcanzar en distancias cortas la velocidad de 110 Km/h', 'El tamaño de su cerebro es igual al del dedo pulgar de una persona', 'Aguantan hasta 10 días sin beber agua', 'Puede “oler” la sangre humana desde una distancia de hasta 50 kilómetros', 'Puede vivir nueve días sin su cabeza, antes de morir de hambre', 6, 5, 4, 2, 3, 1),
(8, 'Hormigas', 'Búho', 'Mosquito', 'Corales', 'Chimpancé', 'Colibrí', 'Su corazón late hasta 1.000 veces por minuto', 'Es el único animal visible desde el espacio', 'No duermen', 'Puede girar la cabeza 360 grados', 'Tiene el récord de rapidez en el acto sexual entre los mamíferos', 'Tiene 47 dientes', 6, 4, 1, 2, 5, 3),
(9, 'Delfines', 'Avestruz', 'Guepardo', 'Elefantes', 'Erizos', 'Cocodrilo', 'Es el animal que más velocidad puede alcanzar corriendo sobre 2 patas', 'Duermen con un ojo abierto', 'Son los únicos mamíferos que no pueden saltar', 'No puede sacar la lengua', 'Ven todo de color amarillo', 'Es el animal más rápido a cuatro patas pudiendo alcanzar hasta 100 Km/h', 2, 1, 4, 6, 5, 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE IF NOT EXISTS `usuario` (
  `nombre` varchar(50) NOT NULL,
  `clave` varchar(50) NOT NULL,
  `puntos` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`nombre`, `clave`, `puntos`) VALUES
('jorge', 'curioso', 60),
('usuario', '123', 7120),
('usuario2', '123', 0),
('usuario3', '123', 3680),
('usuario4', '123', 0),
('usuario5', '123', 0),
('usuario6', '123', 4340),
('william', '123', 0);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `preguntajuego2`
--
ALTER TABLE `preguntajuego2`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `preguntajuego3`
--
ALTER TABLE `preguntajuego3`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `preguntajuego4`
--
ALTER TABLE `preguntajuego4`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `preguntajuego5`
--
ALTER TABLE `preguntajuego5`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD UNIQUE KEY `_nombre` (`nombre`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `preguntajuego2`
--
ALTER TABLE `preguntajuego2`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=31;
--
-- AUTO_INCREMENT de la tabla `preguntajuego3`
--
ALTER TABLE `preguntajuego3`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=22;
--
-- AUTO_INCREMENT de la tabla `preguntajuego4`
--
ALTER TABLE `preguntajuego4`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=41;
--
-- AUTO_INCREMENT de la tabla `preguntajuego5`
--
ALTER TABLE `preguntajuego5`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=10;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
