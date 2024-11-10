/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bingeboxdb;

import java.util.List;
import java.util.Scanner;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Armando
 */
public class MenuConsolaHibernate {

    private static SessionFactory sessionFactory;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Realizamos el menu por consola para controlar nuestra base de datos.
        try {
            sessionFactory = new Configuration().configure("/bingeboxdb/hibernate.cfg.xml").addAnnotatedClass(Actors_NaM.class).buildSessionFactory();

            while (true) {
                // Mostramos el menu en cuestion por consola:

                System.out.println("¡Bienvenido al menú de BingeBox DB! ¿Que deseas realizar?");
                System.out.println("1. Crear un nuevo objeto");
                System.out.println("2. Actualizar un objeto existente");
                System.out.println("3. Eliminar un objeto existente");
                System.out.println("4. Consultar objetos existentes");
                System.out.println("5. Abandonar nuestro programa");
                System.out.println("");
                System.out.println("Introduce el numero de la opcion que desees: ");

                int opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1:
                        crearObjeto();
                        break;
                    case 2:
                        updateObjeto();
                        break;
                    case 3:
                        eliminarObjeto();
                        break;
                    case 4:
                        consultarObjeto();
                        break;
                    case 5:
                        // Se cierra la sesion, acabando el programa.
                        sessionFactory.close();
                        System.out.println("¡Hasta pronto!");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Opción no válida. Por favor, introduce un número del 1 al 5.");
                        System.out.println("");
                        System.out.println("");
                }

            }

        } catch (HibernateException he) {
            System.out.println("Error en Hibernate: " + he.getMessage());
        }
    }

    // M E T O D O S  D E L  M E N U
    // Metodo que regresa al Menú Principal
    private static void volverAlMenu() {
        try {
            sessionFactory = new Configuration().configure("/bingeboxdb/hibernate.cfg.xml").addAnnotatedClass(Actors_NaM.class).buildSessionFactory();

            while (true) {
                // Mostramos el menu en cuestion por consola:

                System.out.println("¡Bienvenido al menú de BingeBox DB! ¿Que deseas realizar?");
                System.out.println("1. Crear un nuevo objeto");
                System.out.println("2. Actualizar un objeto existente");
                System.out.println("3. Eliminar un objeto existente");
                System.out.println("4. Abandonar nuestro programa");
                System.out.println("");
                System.out.println("Introduce el numero de la opcion que desees: ");

                int opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1:
                        crearObjeto();
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        // Se cierra la sesion, acabando el programa.
                        sessionFactory.close();
                        System.out.println("¡Hasta pronto!");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Opción no válida. Por favor, introduce un número del 1 al 4.");
                        System.out.println("");
                        System.out.println("");
                }

            }

        } catch (HibernateException he) {
            System.out.println("Error en Hibernate: " + he.getMessage());
        }
    }

    // Metodo llamado 'crearObjeto' el cual crea el objeto, mediante un menu, y cada case tiene un metodo que controla cada tabla en cuestion.
    private static void crearObjeto() {
        System.out.println("");
        System.out.println("");
        System.out.println("Elige la tabla a la que le quieras hacer un INSERT");
        System.out.println("1. Actors");
        System.out.println("2. Películas");
        System.out.println("3. Directors");
        System.out.println("4. Series");
        System.out.println("5. Temporadas");
        System.out.println("6. Capitulos");
        System.out.println("7. Creador_Serie");
        System.out.println("8. Volver al menú principal");
        System.out.print("Introduce el numero de la opcion que desees: ");
        int opcion2 = scanner.nextInt();
        scanner.nextLine();

        switch (opcion2) {
            case 1:
                insertarEnActors();
                break;
            case 2:
                insertarEnPeliculas();
                break;
            case 3:
                insertarEnDirectors();
                break;
            case 4:
                insertarEnSeries();
                break;
            case 5:
                insertarEnTemporadas();
                break;
            case 6:
                insertarEnCapitulos();
                break;
            case 7:
                insertarEnCreadorSerie();
                break;
            case 8:
                volverAlMenu();
            default:
                System.out.println("Opción no válida. Por favor, introduce un número del 1 al 8.");
                System.out.println("");
                System.out.println("");

        }
    }

    // Metodo llamado 'updateObjeto' el cual actualiza cualquier valor de cualquier columna de cualquier tabla.
    private static void updateObjeto() {
        System.out.println("");
        System.out.println("");
        System.out.println("Elige la tabla a la que le quieras hacer un UPDATE");
        System.out.println("1. Actors");
        System.out.println("2. Películas");
        System.out.println("3. Directors");
        System.out.println("4. Series");
        System.out.println("5. Temporadas");
        System.out.println("6. Capitulos");
        System.out.println("7. Creador_Serie");
        System.out.println("8. Volver al menú principal");
        System.out.print("Introduce el numero de la opcion que desees: ");
        System.out.println("");
        int opcion2 = scanner.nextInt();
        scanner.nextLine();

        switch (opcion2) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                volverAlMenu();
            default:
                System.out.println("Opción no válida. Por favor, introduce un número del 1 al 8.");
                System.out.println("");
                System.out.println("");

        }
    }

    // Metodo llamado 'eliminarObjeto' el cual elimina el objeto.
    private static void eliminarObjeto() {
        System.out.println("");
        System.out.println("");
        System.out.println("Elige la tabla a la que le quieras hacer un DELETE");
        System.out.println("1. Actors");
        System.out.println("2. Películas");
        System.out.println("3. Directors");
        System.out.println("4. Series");
        System.out.println("5. Temporadas");
        System.out.println("6. Capitulos");
        System.out.println("7. Creador_Serie");
        System.out.println("8. Volver al menú principal");
        System.out.print("Introduce el numero de la opcion que desees: ");
        int opcion2 = scanner.nextInt();
        scanner.nextLine();

        switch (opcion2) {
            case 1:
                borrarEnActors();
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                volverAlMenu();
            default:
                System.out.println("Opción no válida. Por favor, introduce un número del 1 al 8.");
                System.out.println("");
                System.out.println("");

        }
    }

    // Metodo llamado 'consultarObjeto' que consulta todos los valores de una tabla.
    private static void consultarObjeto() {
        System.out.println("");
        System.out.println("");
        System.out.println("Elige la tabla que quieras consultar");
        System.out.println("1. Actors");
        System.out.println("2. Películas");
        System.out.println("3. Directors");
        System.out.println("4. Series");
        System.out.println("5. Temporadas");
        System.out.println("6. Capitulos");
        System.out.println("7. Creador_Serie");
        System.out.println("8. Volver al menú principal");
        System.out.print("Introduce el numero de la opcion que desees: ");
        int opcion2 = scanner.nextInt();
        scanner.nextLine();

        switch (opcion2) {
            case 1:
                consultarActors();
                break;
            case 2:
                consultarPeliculas();
                break;
            case 3:
                consultarDirectors();
                break;
            case 4:
                consultarSeries();
                break;
            case 5:
                consultarTemporadas();
                break;
            case 6:
                consultarCapitulos();
                break;
            case 7:
                consultarCreador_Serie();
                break;
            case 8:
                volverAlMenu();
            default:
                System.out.println("Opción no válida. Por favor, introduce un número del 1 al 8.");
                System.out.println("");
                System.out.println("");

        }
    }

    // M E T O D O S  P A R A  L A S  I N S E R C I O N E S
    private static void insertarEnActors() {
        try {
            // Crear un SessionFactory
            SessionFactory instancia = new Configuration().configure("/bingeboxdb/hibernate.cfg.xml").addAnnotatedClass(Actors_NaM.class).buildSessionFactory();
            Session session = instancia.openSession();

            // Usar Scanner para leer los valores de entrada
            System.out.print("Introduce el nombre: ");
            String nombre = scanner.nextLine();

            System.out.print("Introduce la nacionalidad: ");
            String nacionalidad = scanner.nextLine();

            System.out.print("Introduce el género: ");
            String genero = scanner.nextLine();

            // Crear el objeto Actor con los valores leídos
            Actors_NaM a = new Actors_NaM(nombre, nacionalidad, genero);

            // Iniciar transacción, guardar el objeto y confirmar la transacción
            session.beginTransaction();
            session.save(a);
            session.getTransaction().commit();
            System.out.println("Registro insertado en la tabla Actors");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("");
        } catch (HibernateException he) {
            System.out.println(he);
        }
    }

    private static void insertarEnPeliculas() {
        try {
            // Crear un SessionFactory
            SessionFactory instancia = new Configuration().configure("/bingeboxdb/hibernate.cfg.xml").addAnnotatedClass(Peliculas_NaM.class).buildSessionFactory();
            Session session = instancia.openSession();

            // Usar Scanner para leer los valores de entrada
            System.out.print("Introduce el título: ");
            String titulo = scanner.nextLine();

            System.out.print("Introduce el genero: ");
            String genero = scanner.nextLine();

            System.out.print("Introduce la duracion: ");
            String duracion = scanner.nextLine();

            System.out.print("Introduce el rating: ");
            String rating = scanner.nextLine();

            System.out.print("Introduce el pais de la película: ");
            String pais_pelicula = scanner.nextLine();

            System.out.print("Introduce el presupuesto: ");
            Integer presupuesto = scanner.nextInt();

            // Crear el objeto Actor con los valores leídos
            Peliculas_NaM p = new Peliculas_NaM(titulo, genero, duracion, rating, pais_pelicula, presupuesto);

            // Iniciar transacción, guardar el objeto y confirmar la transacción
            session.beginTransaction();
            session.save(p);
            session.getTransaction().commit();
            System.out.println("Registro insertado en la tabla Películas");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("");
        } catch (HibernateException he) {
            System.out.println(he);
        }
    }

    private static void insertarEnSeries() {
        try {
            // Crear un SessionFactory
            SessionFactory instancia = new Configuration().configure("/bingeboxdb/hibernate.cfg.xml").addAnnotatedClass(Series_1aN.class).buildSessionFactory();
            Session session = instancia.openSession();

            // Usar Scanner para leer los valores de entrada
            System.out.print("Introduce el título: ");
            String titulo = scanner.nextLine();

            System.out.print("Introduce el genero: ");
            String genero = scanner.nextLine();

            System.out.print("Introduce el comienzo de la serie: ");
            String comienzo_serie = scanner.nextLine();

            System.out.print("Introduce el final de la serie: ");
            String final_serie = scanner.nextLine();

            System.out.print("Introduce el pais de la serie: ");
            String pais_serie = scanner.nextLine();

            System.out.print("Introduce el numero de temporadas: ");
            Integer num_temporadas = scanner.nextInt();

            System.out.print("Introduce el numero de capitulos: ");
            Integer num_capitulos = scanner.nextInt();

            // Crear el objeto Actor con los valores leídos
            Series_1aN s = new Series_1aN(titulo, genero, comienzo_serie, final_serie, pais_serie, num_temporadas, num_capitulos);

            // Iniciar transacción, guardar el objeto y confirmar la transacción
            session.beginTransaction();
            session.save(s);
            session.getTransaction().commit();
            System.out.println("Registro insertado en la tabla Series");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("");
        } catch (HibernateException he) {
            System.out.println(he);
        }
    }

    private static void insertarEnDirectors() {
        try {
            // Crear un SessionFactory
            SessionFactory instancia = new Configuration().configure("/bingeboxdb/hibernate.cfg.xml").addAnnotatedClass(Directors_NaM.class).buildSessionFactory();
            Session session = instancia.openSession();

            // Usar Scanner para leer los valores de entrada
            System.out.print("Introduce el nombre: ");
            String nombre = scanner.nextLine();

            System.out.print("Introduce la nacionalidad: ");
            String nacionalidad = scanner.nextLine();

            System.out.print("Introduce el género: ");
            String genero = scanner.nextLine();

            // Crear el objeto Actor con los valores leídos
            Directors_NaM d = new Directors_NaM(nombre, nacionalidad, genero);

            // Iniciar transacción, guardar el objeto y confirmar la transacción
            session.beginTransaction();
            session.save(d);
            session.getTransaction().commit();
            System.out.println("Registro insertado en la tabla Directors");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("");
        } catch (HibernateException he) {
            System.out.println(he);
        }
    }

    private static void insertarEnTemporadas() {
        try {
            // Crear un SessionFactory
            SessionFactory instancia = new Configuration().configure("/bingeboxdb/hibernate.cfg.xml").addAnnotatedClass(Temporadas_1aN.class).buildSessionFactory();
            Session session = instancia.openSession();

            // Usar Scanner para leer los valores de entrada
            System.out.print("Introduce el número de la temporada: ");
            Integer numero_temporada = scanner.nextInt();

            System.out.print("Introduce el año de estreno de la temporada: ");
            Integer año_estreno = scanner.nextInt();

            System.out.print("Introduce el número de episodios de la temporada: ");
            Integer num_episodios = scanner.nextInt();

            System.out.print("Introduce el ID de la serie: ");
            Integer id_serie = scanner.nextInt();

            // Crear el objeto Actor con los valores leídos
            Temporadas_1aN t = new Temporadas_1aN(numero_temporada, año_estreno, num_episodios, id_serie);

            // Iniciar transacción, guardar el objeto y confirmar la transacción
            session.beginTransaction();
            session.save(t);
            session.getTransaction().commit();
            System.out.println("Registro insertado en la tabla Temporadas");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("");
        } catch (HibernateException he) {
            System.out.println(he);
        }
    }

    private static void insertarEnCapitulos() {
        try {
            // Crear un SessionFactory
            SessionFactory instancia = new Configuration().configure("/bingeboxdb/hibernate.cfg.xml").addAnnotatedClass(Capitulos.class).buildSessionFactory();
            Session session = instancia.openSession();

            // Usar Scanner para leer los valores de entrada
            System.out.print("Introduce el título del capítulo: ");
            String titulo_capitulo = scanner.nextLine();

            System.out.print("Introduce el número del episodio: ");
            Integer num_episodio = scanner.nextInt();

            System.out.print("Introduce la duración del episodio: ");
            String duracion_episodio = scanner.nextLine();

            System.out.print("Introduce el director del episodio: ");
            String director_episodio = scanner.nextLine();

            System.out.print("Introduce el guionista del episodio: ");
            String guionista_episodio = scanner.nextLine();

            System.out.print("Introduce el ID de la temporada: ");
            Integer id_temporada = scanner.nextInt();

            // Crear el objeto Actor con los valores leídos
            Capitulos c = new Capitulos(titulo_capitulo, num_episodio, duracion_episodio, director_episodio, guionista_episodio, id_temporada);

            // Iniciar transacción, guardar el objeto y confirmar la transacción
            session.beginTransaction();
            session.save(c);
            session.getTransaction().commit();
            System.out.println("Registro insertado en la tabla Capitulos");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("");
        } catch (HibernateException he) {
            System.out.println(he);
        }
    }

    private static void insertarEnCreadorSerie() {
        try {
            // Crear un SessionFactory
            SessionFactory instancia = new Configuration().configure("/bingeboxdb/hibernate.cfg.xml").addAnnotatedClass(Creador_Serie_NaM.class).buildSessionFactory();
            Session session = instancia.openSession();

            // Usar Scanner para leer los valores de entrada
            System.out.print("Introduce el nombre: ");
            String nombre = scanner.nextLine();

            System.out.print("Introduce la nacionalidad: ");
            String nacionalidad = scanner.nextLine();

            System.out.print("Introduce el género: ");
            String genero = scanner.nextLine();

            // Crear el objeto Actor con los valores leídos
            Creador_Serie_NaM c = new Creador_Serie_NaM(nombre, nacionalidad, genero);

            // Iniciar transacción, guardar el objeto y confirmar la transacción
            session.beginTransaction();
            session.save(c);
            session.getTransaction().commit();
            System.out.println("Registro insertado en la tabla Creador_Serie");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("");
        } catch (HibernateException he) {
            System.out.println(he);
        }
    }
    // M E T O D O S  P A R A  L O S  U P D A T E

    // M E T O D O S  P A R A  L O S  D E L E T E
    private static void borrarEnActors() {
        try {
            // Crear un SessionFactory
            SessionFactory instancia = new Configuration().configure("/bingeboxdb/hibernate.cfg.xml")
                    .addAnnotatedClass(Actors_NaM.class).buildSessionFactory();
            Session session = instancia.openSession();

            // Usar Scanner para leer el valor de entrada (en este caso, el nombre)
            System.out.print("Introduce el nombre del actor que deseas eliminar: ");
            String nombre = scanner.nextLine();

            // Iniciar transacción
            session.beginTransaction();

            // Realizar la consulta para buscar al actor por su nombre (o algún otro criterio)
            Actors_NaM actor = session.createQuery("FROM Actors_NaM WHERE nombre_actor = :nombre", Actors_NaM.class).setParameter("nombre", nombre).uniqueResult();

            // Verificar si se encontró el actor
            if (actor != null) {
                // Eliminar el actor encontrado
                session.delete(actor);
                session.getTransaction().commit();
                System.out.println("Actor eliminado de la base de datos.");
            } else {
                System.out.println("No se encontró un actor con ese nombre.");
            }

            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("");
        } catch (HibernateException he) {
            System.out.println(he);
        }

    }

    // M E T O D O S  P A R A  L A S  C O N S U L T A S
    private static void consultarActors() {
        SessionFactory instancia = new Configuration().configure("/bingeboxdb/hibernate.cfg.xml").addAnnotatedClass(Actors_NaM.class).buildSessionFactory();

        try (Session session = instancia.openSession()) {

            System.out.println("Selecciona la columna por la que deseas buscar:");
            System.out.println("1. Nombre del actor");
            System.out.println("2. Nacionalidad del actor");
            System.out.println("3. Género del actor");
            System.out.print("Introduce el número de tu elección: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            String columna = null;
            switch (opcion) {
                case 1:
                    columna = "nombre_actor";
                    break;
                case 2:
                    columna = "nacionalidadActor";
                    break;
                case 3:
                    columna = "genero_actor";
                    break;
                default:
                    System.out.println("Opción no válida.");
                    return;
            }

            System.out.print("Introduce el valor de la columna " + columna + ": ");
            String valor = scanner.nextLine();

            // Se realiza la consulta
            String selectActors = "FROM Actors WHERE " + columna + " = :valor";
            Query<Actors_NaM> query = session.createQuery(selectActors, Actors_NaM.class);
            query.setParameter("valor", valor);

            List<Actors_NaM> resultados = query.list();

            // Se muestran los resultados correspondientes
            if (resultados.isEmpty()) {
                System.out.println("No se ha encontrado ningún actor ni actriz.");
            } else {
                System.out.println("");
                System.out.println("A C T O R E S  E N C O N T R A D O S");
                System.out.println("");
                for (Actors_NaM actor : resultados) {
                    System.out.println("Nombre: " + actor.getNombre_actor());
                    System.out.println("Nacionalidad: " + actor.getNacionalidadActor());
                    System.out.println("Género: " + actor.getGenero_actor());
                    System.out.println("");
                }
            }
            consultarObjeto();

        } catch (HibernateException he) {
            System.out.println(he);
        } finally {
            instancia.close();
        }
    }

    private static void consultarPeliculas() {
        SessionFactory instancia = new Configuration().configure("/bingeboxdb/hibernate.cfg.xml").addAnnotatedClass(Peliculas_NaM.class).buildSessionFactory();

        try (Session session = instancia.openSession()) {

            System.out.println("Selecciona la columna por la que deseas buscar:");
            System.out.println("1. Nombre de la pelicula");
            System.out.println("2. Genero de la pelicula");
            System.out.println("3. Duracion de la pelicula");
            System.out.println("4. Rating de la pelicula");
            System.out.println("5. Pais de la pelicula");
            System.out.println("6. Presupuesto de la pelicula");
            System.out.print("Introduce el número de tu elección: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            String columna = null;
            switch (opcion) {
                case 1:
                    columna = "titulo";
                    break;
                case 2:
                    columna = "genero";
                    break;
                case 3:
                    columna = "duracion";
                    break;
                case 4:
                    columna = "rating";
                    break;
                case 5:
                    columna = "pais_pelicula";
                    break;
                case 6:
                    columna = "presupuesto";
                    break;
                default:
                    System.out.println("Opción no válida.");
                    return;
            }

            System.out.print("Introduce el valor de la columna " + columna + ": ");
            String valor = scanner.nextLine();

            // Se realiza la consulta
            String selectPeliculas = "FROM Peliculas WHERE " + columna + " = :valor";
            Query<Peliculas_NaM> query = session.createQuery(selectPeliculas, Peliculas_NaM.class);
            query.setParameter("valor", valor);

            List<Peliculas_NaM> resultados = query.list();

            // Se muestran los resultados correspondientes
            if (resultados.isEmpty()) {
                System.out.println("No se ha encontrado ninguna pelicula.");
            } else {
                System.out.println("");
                System.out.println("P E L I C U L A S  E N C O N T R A D A S");
                System.out.println("");
                for (Peliculas_NaM peliculas : resultados) {
                    System.out.println("Nombre de la pelicula: " + peliculas.getTitulo());
                    System.out.println("Género de la película: " + peliculas.getGenero());
                    System.out.println("Duración de la película: " + peliculas.getDuracion());
                    System.out.println("Rating de la película: " + peliculas.getRating());
                    System.out.println("País de la película: " + peliculas.getPais_pelicula());
                    System.out.println("Presupuesto de la película: " + peliculas.getPresupuesto());
                    System.out.println("");
                }
            }
            consultarObjeto();

        } catch (HibernateException he) {
            System.out.println(he);
        } finally {
            instancia.close();
        }
    }

    private static void consultarDirectors() {
        SessionFactory instancia = new Configuration().configure("/bingeboxdb/hibernate.cfg.xml").addAnnotatedClass(Directors_NaM.class).buildSessionFactory();

        try (Session session = instancia.openSession()) {

            System.out.println("Selecciona la columna por la que deseas buscar:");
            System.out.println("1. Nombre del director");
            System.out.println("2. Nacionalidad del director");
            System.out.println("3. Genero del director");
            System.out.print("Introduce el número de tu elección: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            String columna = null;
            switch (opcion) {
                case 1:
                    columna = "nombre";
                    break;
                case 2:
                    columna = "nacionalidad";
                    break;
                case 3:
                    columna = "genero";
                    break;
                default:
                    System.out.println("Opción no válida.");
                    return;
            }

            System.out.print("Introduce el valor de la columna " + columna + ": ");
            String valor = scanner.nextLine();

            // Se realiza la consulta
            String selectDirectors = "FROM Directors WHERE " + columna + " = :valor";
            Query<Directors_NaM> query = session.createQuery(selectDirectors, Directors_NaM.class);
            query.setParameter("valor", valor);

            List<Directors_NaM> resultados = query.list();

            // Se muestran los resultados correspondientes
            if (resultados.isEmpty()) {
                System.out.println("No se ha encontrado ningun director.");
            } else {
                System.out.println("");
                System.out.println("D I R E C T O R E S  E N C O N T R A D O S");
                System.out.println("");
                for (Directors_NaM directors : resultados) {
                    System.out.println("Nombre del director: " + directors.getNombre());
                    System.out.println("Nacionalidad del director: " + directors.getNacionalidad());
                    System.out.println("Genero del director: " + directors.getGenero());
                    System.out.println("");
                }
            }
            consultarObjeto();

        } catch (HibernateException he) {
            System.out.println(he);
        } finally {
            instancia.close();
        }
    }

    private static void consultarSeries() {
        SessionFactory instancia = new Configuration().configure("/bingeboxdb/hibernate.cfg.xml").addAnnotatedClass(Series_1aN.class).buildSessionFactory();

        try (Session session = instancia.openSession()) {

            System.out.println("Selecciona la columna por la que deseas buscar:");
            System.out.println("1. Título de la serie");
            System.out.println("2. Genero de la serie");
            System.out.println("3. Comienzo de la serie");
            System.out.println("4. Final de la serie");
            System.out.println("5. Pais de la serie");
            System.out.println("6. Número de temporadas de la serie");
            System.out.println("7. Número de capítulos de la serie");
            System.out.print("Introduce el número de tu elección: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            String columna = null;
            switch (opcion) {
                case 1:
                    columna = "titulo";
                    break;
                case 2:
                    columna = "genero";
                    break;
                case 3:
                    columna = "comienzo_serie";
                    break;
                case 4:
                    columna = "final_serie";
                    break;
                case 5:
                    columna = "pais_serie";
                    break;
                case 6:
                    columna = "num_temporadas";
                    break;
                case 7:
                    columna = "num_capitulos";
                    break;
                default:
                    System.out.println("Opción no válida.");
                    return;
            }

            System.out.print("Introduce el valor de la columna " + columna + ": ");
            String valor = scanner.nextLine();

            // Se realiza la consulta
            String selectSeries = "FROM Series WHERE " + columna + " = :valor";
            Query<Series_1aN> query = session.createQuery(selectSeries, Series_1aN.class);
            query.setParameter("valor", valor);

            List<Series_1aN> resultados = query.list();

            // Se muestran los resultados correspondientes
            if (resultados.isEmpty()) {
                System.out.println("No se ha encontrado ninguna serie.");
            } else {
                System.out.println("");
                System.out.println("S E R I E S  E N C O N T R A D A S");
                System.out.println("");
                for (Series_1aN series : resultados) {
                    System.out.println("Nombre de la serie: " + series.getTitulo());
                    System.out.println("Género de la serie: " + series.getGenero());
                    System.out.println("Comienzo de la serie: " + series.getComienzo_serie());
                    System.out.println("Final de la serie: " + series.getFinal_serie());
                    System.out.println("País de la serie: " + series.getPais_serie());
                    System.out.println("Número de temporadas de la serie: " + series.getNum_temporadas());
                    System.out.println("Número de capítulos de la serie: " + series.getNum_capitulos());
                    System.out.println("");
                }
            }
            consultarObjeto();

        } catch (HibernateException he) {
            System.out.println(he);
        } finally {
            instancia.close();
        }
    }

    private static void consultarTemporadas() {
        SessionFactory instancia = new Configuration().configure("/bingeboxdb/hibernate.cfg.xml").addAnnotatedClass(Temporadas_1aN.class).buildSessionFactory();

        try (Session session = instancia.openSession()) {

            System.out.println("Selecciona la columna por la que deseas buscar:");
            System.out.println("1. Número de la temporada");
            System.out.println("2. Año del estreno de la temporada");
            System.out.println("3. Número de episodios");
            System.out.println("4. ID de la serie");
            System.out.print("Introduce el número de tu elección: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            String columna = null;
            switch (opcion) {
                case 1:
                    columna = "num_temporada";
                    break;
                case 2:
                    columna = "año_estreno";
                    break;
                case 3:
                    columna = "num_episodios";
                    break;
                case 4:
                    columna = "series_id";
                    break;
                default:
                    System.out.println("Opción no válida.");
                    return;
            }

            System.out.print("Introduce el valor de la columna " + columna + ": ");
            String valor = scanner.nextLine();

            // Se realiza la consulta
            String selectTemporadas = "FROM Temporadas WHERE " + columna + " = :valor";
            Query<Temporadas_1aN> query = session.createQuery(selectTemporadas, Temporadas_1aN.class);
            query.setParameter("valor", valor);

            List<Temporadas_1aN> resultados = query.list();

            // Se muestran los resultados correspondientes
            if (resultados.isEmpty()) {
                System.out.println("No se ha encontrado ningún actor ni actriz.");
            } else {
                System.out.println("");
                System.out.println("T E M P O R A D A S  E N C O N T R A D A S");
                System.out.println("");
                for (Temporadas_1aN temporadas : resultados) {
                    System.out.println("Número de la temporada: " + temporadas.getNum_temporada());
                    System.out.println("Año del estreno de la temporada: " + temporadas.getAño_estreno());
                    System.out.println("Número de episodios de la temporada: " + temporadas.getNum_episodios());
                    System.out.println("El ID de la serie de la temporada:" + temporadas.getSeries_id());
                }
            }
            consultarObjeto();

        } catch (HibernateException he) {
            System.out.println(he);
        } finally {
            instancia.close();
        }
    }

    private static void consultarCapitulos() {
        SessionFactory instancia = new Configuration().configure("/bingeboxdb/hibernate.cfg.xml").addAnnotatedClass(Capitulos.class).buildSessionFactory();

        try (Session session = instancia.openSession()) {

            System.out.println("Selecciona la columna por la que deseas buscar:");
            System.out.println("1. Nombre del capitulo");
            System.out.println("2. Numero del episodio");
            System.out.println("3. Duracion del episodio");
            System.out.println("4. Director del episodio");
            System.out.println("5. Guionista del episodio");
            System.out.println("6. ID de la temporada");
            System.out.print("Introduce el número de tu elección: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            String columna = null;
            switch (opcion) {
                case 1:
                    columna = "titulo_capitulo";
                    break;
                case 2:
                    columna = "numero_episodio";
                    break;
                case 3:
                    columna = "duracion_episodio";
                    break;
                case 4:
                    columna = "director_episodio";
                    break;
                case 5:
                    columna = "guionista_episodio";
                    break;
                case 6:
                    columna = "temporada_id";
                    break;
                default:
                    System.out.println("Opción no válida.");
                    return;
            }

            System.out.print("Introduce el valor de la columna " + columna + ": ");
            String valor = scanner.nextLine();

            // Se realiza la consulta
            String selectCapitulo = "FROM Capitulos WHERE " + columna + " = :valor";
            Query<Capitulos> query = session.createQuery(selectCapitulo, Capitulos.class);
            query.setParameter("valor", valor);

            List<Capitulos> resultados = query.list();

            // Se muestran los resultados correspondientes
            if (resultados.isEmpty()) {
                System.out.println("No se ha encontrado ningun capitulo.");
            } else {
                System.out.println("");
                System.out.println("C A P I T U L O S  E N C O N T R A D A S");
                System.out.println("");
                for (Capitulos capitulos : resultados) {
                    System.out.println("Titulo del capitulo: " + capitulos.getTitulo_capitulo());
                    System.out.println("Número del episodio: " + capitulos.getNumero_episodio());
                    System.out.println("Duración del episodio: " + capitulos.getDuracion_episodio());
                    System.out.println("Director del episodio: " + capitulos.getDirector_episodio());
                    System.out.println("Guionista del episodio: " + capitulos.getGuionista_episodio());
                    System.out.println("ID de la temporada: " + capitulos.getTemporada_id());
                    System.out.println("");
                }
            }
            consultarObjeto();

        } catch (HibernateException he) {
            System.out.println(he);
        } finally {
            instancia.close();
        }
    }

    private static void consultarCreador_Serie() {
        SessionFactory instancia = new Configuration().configure("/bingeboxdb/hibernate.cfg.xml").addAnnotatedClass(Creador_Serie_NaM.class).buildSessionFactory();

        try (Session session = instancia.openSession()) {

            System.out.println("Selecciona la columna por la que deseas buscar:");
            System.out.println("1. Nombre del creador");
            System.out.println("2. Nacionalidad del creador");
            System.out.println("3. Género del creador");
            System.out.print("Introduce el número de tu elección: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            String columna = null;
            switch (opcion) {
                case 1:
                    columna = "nombre";
                    break;
                case 2:
                    columna = "nacionalidad";
                    break;
                case 3:
                    columna = "genero";
                    break;
                default:
                    System.out.println("Opción no válida.");
                    return;
            }

            System.out.print("Introduce el valor de la columna " + columna + ": ");
            String valor = scanner.nextLine();

            // Se realiza la consulta
            String selectCreador_Serie = "FROM Creador_Serie WHERE " + columna + " = :valor";
            Query<Creador_Serie_NaM> query = session.createQuery(selectCreador_Serie, Creador_Serie_NaM.class);
            query.setParameter("valor", valor);

            List<Creador_Serie_NaM> resultados = query.list();

            // Se muestran los resultados correspondientes
            if (resultados.isEmpty()) {
                System.out.println("No se ha encontrado ningún actor ni actriz.");
            } else {
                System.out.println("");
                System.out.println("C R E A D O R E S  E N C O N T R A D O S");
                System.out.println("");
                for (Creador_Serie_NaM creador_serie : resultados) {
                    System.out.println("Nombre: " + creador_serie.getNombre());
                    System.out.println("Nacionalidad: " + creador_serie.getNacionalidad());
                    System.out.println("Género: " + creador_serie.getGenero());
                    System.out.println("");
                }
            }
            consultarObjeto();

        } catch (HibernateException he) {
            System.out.println(he);
        } finally {
            instancia.close();
        }
    }
}
