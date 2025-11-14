package ca.mpringle.company.dataannotation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public final class Decoder {


    public static void decodeSecretMessage(final String url)
            throws IOException {

        final String rawHtml = retrievePageRawHtml(URI.create(url));
        final SecretMessage secretMessage = parseHtml(rawHtml);

        System.out.println(secretMessage);
    }

    private static String retrievePageRawHtml(final URI url) throws IOException {

        final StringBuilder builder = new StringBuilder();

        try (final BufferedReader reader = new BufferedReader(new InputStreamReader(url.toURL().openStream()))) {

            String inputLine;
            do {
                inputLine = reader.readLine();
                builder.append(inputLine);
            } while (inputLine != null);
        }

        return builder.toString();
    }

    private static SecretMessage parseHtml(final String html) {

        final Document doc = Jsoup.parse(html);
        final Elements elements = doc.select("td");

        final List<SecretMessageCell> secretMessageCells = new ArrayList<>();

        final Iterator<Element> element = elements.iterator();
        // skip the header row - assumes (badly) that data is x, character, y
        element.next();
        element.next();
        element.next();

        while (element.hasNext()) {

            secretMessageCells.add(
                    new SecretMessageCell(
                            Integer.parseInt(element.next().text()),
                            element.next().text(),
                            Integer.parseInt(element.next().text())
                    )
            );
        }

        return new SecretMessage(secretMessageCells);
    }

    private static class SecretMessage {

        final String[][] cells;

        public SecretMessage(final List<SecretMessageCell> cells) {

            int maxXCoordinate = cells
                    .stream()
                    .map(cell -> cell.x)
                    .max(Integer::compareTo)
                    .orElseThrow();

            int maxYCoordinate = cells
                    .stream()
                    .map(cell -> cell.y)
                    .max(Integer::compareTo)
                    .orElseThrow();

            this.cells = new String[maxYCoordinate+1][maxXCoordinate+1];

            cells.forEach(cell -> this.cells[cell.y][cell.x] = cell.character);
        }

        @Override
        public String toString() {

            StringBuilder builder = new StringBuilder();

            for (int y = cells.length-1; y >= 0; y--) {
                builder.append("\n");
                for (int x = 0; x < cells[y].length; x++) {
                    builder.append(cells[y][x] == null ? " " : cells[y][x]);
                }
            }

            return builder.substring(1);
        }
    }

    private static class SecretMessageCell {

        private final int x;
        private final String character;
        private final int y;

        public SecretMessageCell(final int x, final String character, final int y) {

            this.x = x;
            this.character = character;
            this.y = y;
        }
    }
}
