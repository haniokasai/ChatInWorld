# ChatInWorld
chat separate per-world


##API

###Maven

<repository>
  <id>hani</id>
  <url>http://jenkins.haniokasai.com/plugin/repository/project/ChatInWorld-Nukkit/LastSuccessful/repository/</url>
</repository>

<dependency>
  <groupId>com.haniokasai.nukkit.ChatInWorld</groupId>
  <artifactId>ChatInWorld</artifactId>
  <version>1.0.0-SNAPSHOT</version>
  <scope>provided</scope>
</dependency>

###Code

ChatInWorld a = new ChatInWorld();
a.sendchat("name", "message",Server.getInstance().getDefaultLevel().getName());
