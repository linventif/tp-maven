# Maven TP

## Show Content of file with ClassLoader

File: `src/main/resources/data.txt`

```java
public class App {
    public static void main(String[] args) {
        try {
            InputStream is = App.class.getClassLoader().getResourceAsStream("data.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

## Run

With `mvn`

```bash
mvn exec:java -Dexec.mainClass=fr.but3.App
mvn exec:java
```

With `java`

```bash
java -cp target/tp503a-1.0-SNAPSHOT.jar fr.but3.App
```

With `.jar`

```bash
java -jar target/tp503a-1.0-SNAPSHOT.jar
```

If you have this error: `No main manifest attribute, in target/tp503a-1.0-SNAPSHOT.jar`
You need to add MANIFEST.MF file in `src/main/resources/META-INF` with `Main-Class: fr.but3.App` in it.

```xml:manifest.mf
Manifest-Version: 1.0
Main-Class: fr.but3.App
```

Then, you need to add this file in the jar with `maven-jar-plugin` in `pom.xml`

```xml
<plugin>
  <groupId>org.apache.maven.plugins</groupId>
  <artifactId>maven-jar-plugin</artifactId>
  <version>3.1.0</version>
  <configuration>

</plugin>
```

## Run with `java`

```bash
java -jar target/tp503a-1.0-SNAPSHOT-jar-with-dependencies.jar
```
