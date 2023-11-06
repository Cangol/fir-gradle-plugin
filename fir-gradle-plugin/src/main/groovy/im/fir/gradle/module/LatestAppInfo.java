package im.fir.gradle.module;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LatestAppInfo {
    private static ObjectMapper sJsonMapper = new ObjectMapper();

    public static LatestAppInfo createFromJson(String json) {
        try {
            return sJsonMapper.readValue(json, LatestAppInfo.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String name;
    private String version;
    private int build;
    private String versionShort;
    private String changelog;
    private String install_url;
    private String update_url;
    private Map<String, String> binary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public int getBuild() {
        return build;
    }

    public void setBuild(int build) {
        this.build = build;
    }

    public String getVersionShort() {
        return versionShort;
    }

    public void setVersionShort(String versionShort) {
        this.versionShort = versionShort;
    }

    public String getChangelog() {
        return changelog;
    }

    public void setChangelog(String changelog) {
        this.changelog = changelog;
    }

    public String getInstall_url() {
        return install_url;
    }

    public void setInstall_url(String install_url) {
        this.install_url = install_url;
    }

    public String getUpdate_url() {
        return update_url;
    }

    public void setUpdate_url(String update_url) {
        this.update_url = update_url;
    }

    public Map<String, String> getBinary() {
        return binary;
    }

    public void setBinary(Map<String, String> binary) {
        this.binary = binary;
    }
}
