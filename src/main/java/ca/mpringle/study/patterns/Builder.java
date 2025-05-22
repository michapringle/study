package ca.mpringle.study.patterns;

import java.util.HashSet;
import java.util.Set;

final class Builder {

    private Builder() {
    }

    /**
     * Effective Java 2nd Ed Item 2, pp 11-16
     * Simulates named optional parameters, allows constructed class to be immutable
     * This is "a form o the Builder pattern [Gamma95, p.97]"
     */
    static class EJBuilder {

        private EJBuilder() {
        }

        static class Person {
            private final String firstName;
            private final String middleName;
            private final String lastName;

            private Person(final PersonBuilder builder) {

                firstName = builder.firstName;
                middleName = builder.middleName;
                lastName = builder.lastName;
            }

            static PersonBuilder builder() {
                return new PersonBuilder();
            }

            static class PersonBuilder {

                private String firstName;
                private String middleName;
                private String lastName;

                public PersonBuilder firstName(String firstName) {
                    this.firstName = firstName;
                    return this;
                }

                public PersonBuilder middleName(String middleName) {
                    this.middleName = middleName;
                    return this;
                }

                public PersonBuilder lastName(String lastName) {
                    this.lastName = lastName;
                    return this;
                }

                public Person build() {
                    return new Person(this);
                }
            }
        }
    }

    /**
     * GoF Design Patterns, pp 97-106
     * Separate the construction of a complex object from its representation so that the same
     * construction process can create different representations.
     */
    static class GoFBuilder {

        private GoFBuilder() {
        }

        Maze createMaze(final MazeBuilder builder) {

            builder.buildMaze();
            builder.buildRoom(1);
            builder.buildRoom(2);
            builder.buildDoor(1, 2);
            return builder.getMaze();
        }

        static class Maze {

            private final Set<Integer> rooms;
            private final Set<String> doors;

            public Maze() {

                rooms = new HashSet<>();
                doors = new HashSet<>();
            }

            void addRoom(final int roomNumber) {

                rooms.add(roomNumber);
            }

            void addDoor(final int roomFrom, final int roomTo) {

                if (rooms.contains(roomFrom) && rooms.contains(roomTo)) {
                    doors.add(roomFrom + ":" + roomTo);
                }
            }
        }


        interface MazeBuilder {

            void buildMaze();

            void buildRoom(int roomNumber);

            void buildDoor(int roomFrom, int roomTo);

            Maze getMaze();
        }

        static class StandardMaze implements MazeBuilder {

            private Maze maze;

            @Override
            public void buildMaze() {
                maze = new Maze();
            }

            @Override
            public void buildRoom(int roomNumber) {
                maze.addRoom(roomNumber);

            }

            @Override
            public void buildDoor(int roomFrom, int roomTo) {
                maze.addDoor(roomFrom, roomTo);
            }

            @Override
            public Maze getMaze() {
                return maze;
            }
        }

        static class CountingMaze implements MazeBuilder {

            private Maze maze;
            private int numDoors;
            private int numRooms;

            @Override
            public void buildMaze() {

                maze = new Maze();
                numDoors = 0;
                numRooms = 0;
            }

            @Override
            public void buildRoom(int room) {
                numRooms++;
            }

            @Override
            public void buildDoor(int roomFrom, int roomTo) {
                numDoors++;
            }

            @Override
            public Maze getMaze() {
                return maze;
            }
        }
    }
}