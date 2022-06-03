#!/bin/bash

FECHA_ACTUAL=$(date "+Fecha: %d-%m-%y\n\nHora: %H:%M")
ID_VER_DISTRO=$(lsb_release -r | awk '{print $2}')
VERSION_SISTEMA=$(cat /etc/os-release | grep VERSION= | sed 's/VERSION=//' | tr -d ['"'])

while :; do
	clear
	echo "1 - Ejercicio 1"
	echo "2 - Ejercicio 2"
	echo "3 - Ejercicio 3"
	echo "4 - Ejercicio 4"
	echo "5 - Ejercicio 5"
	echo "6 - Ejercicio 6"
	echo "7 - Ejercicio 7"
	echo "8 - Ejercicio 8"
	echo "9 - Ejercicio 9"
	echo "10 - Ejercicio 10"
	echo -e "0 - Salir\n"

	read -p "Ingrese el numero del ejercicio que desea ejecutar: " opc
	clear

	case $opc in
	0)
		echo "Saliendo..."
		sleep 1
		clear
		break
		;;
	1)
		#1- Mostrar la versión del sistema actual y nombre de usuario.
		echo "Usuario: $USER"
		echo -e "\nVersion sistema: $VERSION_SISTEMA"

		sleep 2
		;;
	2)
		#2- Mostrar el id de la versión de la distribución detectada y la hora y fecha actual.
		echo "ID de la actual versión de distribución: $ID_VER_DISTRO"
		echo -e "\n$FECHA_ACTUAL"

		sleep 3
		;;
	3)
		#3- Mostrar hora actual del equipo como también nombre de usuario y su home.
		echo -e $FECHA_ACTUAL
		echo -e "\nUsuario: $USER"
		echo -e "\nDireccion de home: $HOME\n Contenido:\n"

		ls $HOME

		echo ""

		read -p "Presion enter para continuar: " tec
		;;
	4)
		#4- Mostrar el id del nombre del primer usuario detectado conectado con los minutos actuales."
		echo -e "$FECHA_ACTUAL\n"

		ID_USERNAME_SESSION=$(grep $(who | sed 1q | awk '{print $1}') /etc/passwd | tr -d '[:alpha:]' | cut -d : -f 3)
		echo "ID del primero usuario conectado: $ID_USERNAME_SESSION"

		CONEXION_ESTABLECIDA=$(who | sed 1q | awk '{print $3" "$4}')
		echo -e "\n     Conexion establecida: $CONEXION_ESTABLECIDA"

		DURACION_CONEXION=$(uptime -p | sed 's/up //' | sed 's/hours/horas/' | sed 's/minutes/minutos/')
		echo -e "\n     Duración de la conexion: $DURACION_CONEXION\n"

		read -p "Presion enter para continuar: " tec
		;;
	5)
		#5- Desplegar versión del sistema operativo, así como también la subversión.
		echo "Version sistema: $VERSION_SISTEMA"

		SUBVERSION_SISTEMA=$(lsb_release -d | awk '{print $4}')
		echo -e "\n Subversion: $SUBVERSION_SISTEMA"

		sleep 2
		;;
	6)
		#6- Desplegar el nombre largo del tipo de Sistema Operativo mas el nombre de usuario.
		TIPO_S_O_L="$(uname -o)"
		echo -e "Usuario: $USER \nNombre largo del sistema: $TIPO_S_O_L"
		sleep 2
		;;
	7)
		#7- Mostrar el IUD del superusuario root.
		echo "IUD del superusuario root: $UID"
		sleep 2
		;;
	8)
		#8- Desplegar el nombre de usuario con sesión abierta, la fecha, hora y minuto del sistema.
		echo -e $FECHA_ACTUAL
		echo -e "\n==========================================="
		echo -e "\nUsuarios conectados al sistema\n"

		for ((i = 1; i <= $(who -q | sed -n 2p | cut -d = -f 2); i++)); do
			user=$(who | sed -n $i'p' | awk '{print $1}')

			connect=$(who | sed -n $i'p' | awk '{print $3" "$4}')

			echo -e "Usuario: $user\nConexion: $connect\n"
		done

		echo -e "===========================================\n"

		read -p "Presion enter para continuar: " tec
		;;
	9)
		#9- Mostrar el nombre de la versión de la distribución detectada, como también la versión del bash Shell.
		VER_DISTRO=$(lsb_release -c | awk '{print $2}')
		echo "Nombre de la versión de la distribución del sistema: $VER_DISTRO"

		VERSION_BASH=$(bash --version | grep bash | awk '{print $4}')
		echo -e "\nVersion del bash Shell: $VERSION_BASH"
		sleep 2
		;;
	10)
		#10- Desplegar el nombre corto de la distribución detectada, también el usuario, y fecha del sistema.
		NOM_DISTRO_C=$(lsb_release -d | awk '{print $2}')
		echo $NOM_DISTRO_C

		sleep 2
		;;
	*)
		echo "Opcion incorrecta"
		;;
	esac
done