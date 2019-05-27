import java.util.Objects;

public class Vertex{

    String station;
    int dijkstraValue = Integer.MAX_VALUE;

    public Vertex(String station) {
        this.station = station;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex vertex = (Vertex) o;
        return Objects.equals(station, vertex.station);
    }

    @Override
    public int hashCode() {
        return Objects.hash(station);
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "station='" + station + '\'' +
                '}';
    }

    public int getDijkstraValue() {
        return dijkstraValue;
    }

}
