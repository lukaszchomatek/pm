# Przykład aplikacji w architekturze mikroserwisowej

Niniejszy przykład pokazuje aplikację w architekturze mikrousługowej oraz sposób jej wdrożenia.

### Konfiguracja początkowa

Główne komponenty aplikacji znajdują się na maszynie wirtualnej z systemem Ubuntu 16.04.LTS działającej na oprogramowaniu Oracle VM VirtualBox.

**Instalacja RabbitMQ**

Oprogramowanie RabbitMQ jest serwerem dostarczającym kolejkę AMQP w wersji 0.9.1. Sposób instalacji RabbitMQ został opisany [tutaj](https://tecadmin.net/install-rabbitmq-server-on-ubuntu/). Instalując RabbitMQ wg powyższego tutoriala warto zwrócić uwagę na uruchamianie serwera przy pomocy `systemctl`

**Instalacja JDK 8**

Przebiega przy pomocy `apt-get install openjdk-8-jre` 

**Instalacja Mavena**

Przebiega przy pomocy `apt-get install maven`

