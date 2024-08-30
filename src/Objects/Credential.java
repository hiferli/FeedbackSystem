package Objects;

public class Credential {
    private String Name;
    private String Username;
    private String Password;
    private String SandboxName;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getSandboxName() {
        return SandboxName;
    }

    public void setSandboxName(String sandboxName) {
        SandboxName = sandboxName;
    }
}
