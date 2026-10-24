# VOLTA AERO — Concept Showcase

A futuristic, responsive electric-flight mobility concept website built as a Maven WAR. Includes custom SVG vehicle artwork, animated hero, scroll reveals, responsive navigation, concept dashboard, and a Java Servlet demo API.

> **Important:** This is a fictional portfolio concept, not a real Tesla product or a claim that Tesla has released a flying car. All displayed performance figures are illustrative. The demo form does not save personal data.

## Compatibility

- Java 21
- Maven 3.9+
- Apache Tomcat 9.x
- `javax.servlet` 4.0.1 (Tomcat 9 compatible)
- Jenkins Pipeline

## Run locally

```bash
java -version
mvn -version
mvn clean test package
```

WAR output: `target/volta-aero.war`

Copy it to a Tomcat 9 installation:

```bash
sudo cp target/volta-aero.war /opt/tomcat/webapps/volta-aero.war
```

Change `/opt/tomcat` if your Tomcat installation uses another path. Ensure the Tomcat service account can read the WAR. Then open:

`http://YOUR_SERVER_PUBLIC_IP:8080/volta-aero/`

Health endpoint:

`http://YOUR_SERVER_PUBLIC_IP:8080/volta-aero/api/health`

The reservation form sends a POST to `/api/reserve`. It validates the fields and returns a demo response; it deliberately does not persist names or email addresses.

## Upload to a new GitHub repository

1. Create a **Public** or **Private** repository named `volta-aero-showcase` (do not initialize it with a README if you will push this folder as-is).
2. Extract this ZIP on your computer.
3. Open PowerShell in the extracted `volta-aero-showcase` folder.
4. Run:

```powershell
git init
git add .
git commit -m "Add Volta Aero animated Java web app"
git branch -M main
git remote add origin https://github.com/YOUR-USERNAME/volta-aero-showcase.git
git push -u origin main
```

Replace `YOUR-USERNAME` with your GitHub username.

## Jenkins setup

1. Install/configure JDK 21 and Maven 3 in **Manage Jenkins → Tools**.
2. Add a JDK installation named exactly `Java21` and a Maven installation named exactly `Maven3`, or change the `tools` names in the Jenkinsfile to match your configured names.
3. Create a Pipeline job and connect it to your GitHub repository. Select **Pipeline script from SCM → Git**, branch `*/main`, script path `Jenkinsfile`.
4. Run **Build Now**. It checks out source, runs tests, packages the WAR, and archives `target/volta-aero.war`.

### Deploy stage note

The included pipeline deliberately does **not** copy files to `/opt/tomcat` yet. First verify the correct Tomcat path and configure a least-privilege deployment permission. Do not give Jenkins unrestricted passwordless sudo. Once the build is green, configure the deploy command for your exact EC2/Tomcat service.

## Suggested next upgrades

- Add a database only if you need persistent reservations.
- Add authentication/rate limiting before exposing any real booking endpoint.
- Add a real CI webhook after confirming manual builds work.
- Keep the EC2 security group restricted; expose only required ports.
