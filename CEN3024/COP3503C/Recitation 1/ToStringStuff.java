public class ToStringStuff {
    private String title;
    private String streamservice;


    public Shows(String title, String streamservice) {
        this.title = title;
        this.streamservice = streamservice;
    }

    public String getTitle() {
        return this.title;
    }

    public String getStreamingService() {
        return this.streamservice;
    }

    @Override
    public String toString() {
        return "Title:" + getTitle() + "/n Streaming Service: " + getStreamingService();
    }

    public static void main(String[] args) {
        ToStringStuff s1 = new Shows("Moon Knight", "Disney +");
    }
}
