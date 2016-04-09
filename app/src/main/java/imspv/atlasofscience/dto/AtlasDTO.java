package imspv.atlasofscience.dto;


public class AtlasDTO {

    private String title;
    private String topic;
    private String taskname;
    private String button;




    public AtlasDTO(String title, String topic, String taskname,String button) {
        this.title = title;
        this.topic = topic;
        this.taskname = taskname;
        this.button = button;

    }

    public String getButton() {
        return button;
    }

    public void setButton(String button) {
        this.button = button;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getTaskname() {
        return taskname;
    }

    public void setTaskname(String taskname) {
        this.taskname = taskname;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
