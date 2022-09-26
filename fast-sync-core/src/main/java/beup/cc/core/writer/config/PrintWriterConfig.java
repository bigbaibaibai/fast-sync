package beup.cc.core.writer.config;

public class PrintWriterConfig extends BaseWriterConfig {

    /**
     * json、toString
     */
    private String printType = "json";

    public String getPrintType() {
        return printType;
    }

    public void setPrintType(String printType) {
        this.printType = printType;
    }
}
