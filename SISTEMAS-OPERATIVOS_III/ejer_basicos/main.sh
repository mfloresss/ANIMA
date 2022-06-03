#!/bin/bash

showPermissions() {
	if [ -d $1 ]; then
		echo "La ruta $1 es un directorio"
	elif [ -e $1 ]; then
		echo "La ruta $1 es un archivo"
		echo ""
		sleep 1

		if [ -r $1 ]; then
			echo "El archivo tiene permisos de lectura"
		fi

		if [ -w $1 ]; then
			echo "El archivo tiene permisos de escritura"
		fi

		if [ -x $1 ]; then
			echo "El archivo tiene permisos de ejecución"
		fi

		if [ ! -r "$1" -a ! -w "$1" -a ! -x "$1" ]; then
			echo "El archivo no tiene permisos"
		fi
	else
		echo "La ruta $1 no existe"
	fi
}

while :; do
	clear
	echo "1) - Ejercio 1"
	echo "2) - Ejercio 2"
	echo "3) - Ejercio 3"
	echo "4) - Ejercio 4"
	echo "5) - Ejercio 5"
	echo "6) - Ejercio 6"
	echo "7) - Salir"
	echo ""
	read -p "Seleccione una opcion: " opc

	case $opc in
	1)
		validate_number="^[-0-9]+$"

		clear
		read -p "> Ingrese un numero: " num
		clear

		if [[ $num =~ $validate_number ]]; then
			if [ $num -lt 0 ]; then
				echo "El numero $num es negativo"
			elif [ $num -eq 0 ]; then
				echo "El numero es cero"
			else
				echo "El numero $num es positivo"
			fi
		else
			echo "Debe ingresar un numero"
		fi

		sleep 1
		;;
	2)
		clear
		read -p "Ingrese su nombre: " nombre
		clear

		if [ $nombre = $USER ]; then
			echo "HOLA $nombre !"
			sleep 1
		else
			echo "Usuario Impostor… chau!!!"
			sleep 1
			break
		fi
		;;
	3)
		clear

		if [ $# -eq 0 ]; then
			echo "No se ingreso ningun parametro"
		elif [ $# -le 3 ]; then
			for ((i = 1; i <= $#; i++)); do
				parm=${@:$i:1}
				echo "El parametro $i es $parm"
			done
		else
			echo "ERORR!!!! El script contiene $# parametros"
		fi

		sleep 1
		;;
	4)
		clear
		echo "#!/bin/bash"
		echo "1 - # calculadora"
		echo "2 - clear"
		echo '3 - echo "Calculadora simple"'
		echo '4 - echo "*******************************************"'
		echo '5 - echo -n "Introduzca el primer valor: "'
		echo '6 - read valor1'
		echo '7 - echo -n "Introduzca el operador (+, -, * o /)"'
		echo '8 - read operador'
		echo '9 - echo -n "Introduzca el segundo valor: "'
		echo '10 - read valor2'
		echo '11 - echo "El resultado es..."'
		echo '12 - sleep 1'
		echo '13 - expr $valor1 $operador $valor2'
		echo '14 - sleep 1'
		echo '15 - echo "taluego...."'
		echo ""

		echo 'El error de este script esta en la linea 13 y este se solucionaria poniendo simplemente "" a la variable $operador.'
		echo ""
		echo 'Quedando de la siguiente forma: expr $valor1 "$operador" $valor2'
		echo ""
		read -p "Presione enter para continuar" tec

		;;
	5)
		clear
		echo "1- Archivo con todos los permisos"
		echo "2- Archivo solo con premiso de lectura"
		echo "3- Directorio"
		echo ""
		read -p "Ingrese opcion o una ruta: " tec
		clear

		case $tec in
		1)
			showPermissions "./ejer_5_prueba/x_r_w.sh"
			;;
		2)
			showPermissions "./ejer_5_prueba/r.sh"
			;;
		3)
			showPermissions "./ejer_5_prueba"
			;;
		*)
			showPermissions $tec
			;;
		esac

		sleep 2
		;;
	6)
		clear
		echo "1 - 30 veces la palabra 3eroTIC"
		echo ""
		echo "2 - Ingresar cantidad de numeros a imprimir"
		echo ""
		read -p "Ingrese opcion: " opc
		clear

		case $opc in
		1)
			for ((i = 1; i <= 30; i++)); do
				echo "$i > 3eroTIC"
				sleep 0.1
			done
			;;
		2)
			read -p "Ingrese cantidad de numeros a imprimir: " cant
			clear
			for ((i = 0; i <= $cant; i++)); do
				echo $i
				sleep 0.1
			done
			;;
		*)
			echo "Opcion no valida"
			;;
		esac

		sleep 1
		;;
	7)
		clear
		echo "CHAUUUU :("
		sleep 1
		clear
		break
		;;
	*)
		echo "ERROR!!!! Opcion incorrecta"
		;;
	esac
done
