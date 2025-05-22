package ca.mpringle.study.patterns;

import java.time.ZonedDateTime;

/**
 * 3 patterns
 * - static factory method
 * - factory method
 * - abstract factory
 */
final class Factory {

    private Factory() {
    }

    /**
     * Effective Java 2nd Ed Item 1, pp 5-10
     * Use a static method to replace constructor usage
     */
    static Factory staticFactoryMethod() {
        return new Factory();
    }


    /**
     * GoF Design Patterns, pp 107-116
     * Creation logic is encapsulated within a method
     */
    static class FactoryMethod {

        private FactoryMethod() {
        }

        interface SupplementService {
        }

        static class WinterSupplementService implements SupplementService {
        }

        static class SummerSupplementService implements SupplementService {
        }

        boolean isSummer(final ZonedDateTime dateTime) {
            return true;
        }

        boolean isWinter(final ZonedDateTime dateTime) {
            return true;
        }

        SupplementService createSupplementService(final ZonedDateTime dateTime) {

            if (isSummer(dateTime)) {
                return new SummerSupplementService();
            } else if (isWinter(dateTime)) {
                return new WinterSupplementService();
            }

            final String errorMessage = "Programming error. Date %s not covered in programmed range.";
            throw new AssertionError(String.format(errorMessage, dateTime));
        }
    }

    /**
     * GoF Design Patterns, pp 87-95
     * Creation of related or dependant classes is encapsulated in a factory class
     */
    static class AbstractFactory {

        private AbstractFactory() {
        }

        enum Side {
            NORTH,
            EAST,
            SOUTH,
            WEST
        }

        interface Maze {
            void addRoom(final Room room);
        }

        interface Door {
        }

        interface Wall {
        }

        interface Room {
            void setSide(final Side side, final Wall wall);

            void setSide(final Side side, final Door door);
        }

        /**
         * This abstract factory is simply a collection of factory methods
         */
        interface MazeFactory {

            Maze createMaze();

            Wall createWall();

            Room createRoom();

            Door createDoor();
        }


        /**
         * Any maze made using the factory can ignore the details of the concrete classes
         */
        void createMaze(final MazeFactory factory) {

            final Maze maze = factory.createMaze();

            final Room room1 = factory.createRoom();
            final Room room2 = factory.createRoom();

            room1.setSide(Side.NORTH, factory.createWall());
            room1.setSide(Side.EAST, factory.createDoor());
            room1.setSide(Side.SOUTH, factory.createWall());
            room1.setSide(Side.WEST, factory.createWall());

            room2.setSide(Side.NORTH, factory.createWall());
            room2.setSide(Side.EAST, factory.createWall());
            room2.setSide(Side.SOUTH, factory.createWall());
            room2.setSide(Side.WEST, factory.createDoor());

            maze.addRoom(room1);
            maze.addRoom(room2);
        }
    }
}
