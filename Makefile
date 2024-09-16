build:
	# Executa mvn clean package antes de buildar as imagens
	cd user && mvn clean package -DskipTests
	cd order && mvn clean package -DskipTests
	cd gateway && mvn clean package -DskipTests
	# Builda os containers
	docker compose build

up:
	# Sobe os containers
	docker compose up
