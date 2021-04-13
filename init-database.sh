PGPASSWORD=super_password psql -h localhost -U postgres_user_city cities -f ./data/pais.sql
PGPASSWORD=super_password  psql -h localhost -U postgres_user_city cities -f ./data/estado.sql
PGPASSWORD=super_password psql -h localhost -U postgres_user_city cities -f ./data/cidade.sql

PGPASSWORD=super_password psql -h localhost -U postgres_user_city cities -c "CREATE EXTENSION cube; CREATE EXTENSION earthdistance;"
