# P. Transformación F.

```
Generar DataSource jdbc/FRISADS_DEV
```
Será por ambiente

```
Al cargar en el IDE, contruir con dependencias en el siguiente orden,
```

1) Modelo frisa
2) Servicios frisa

```
Log del aplicativo,
```

Todo el contenido de 'tmp' Dejar sobre C:, quedará carpeta sobre C:\tmp\frisa


```
Incluir la dependencia de Politicas de OWSM que esta en webLogic ubicarla en su systema local o se agrega el GIT en carpeta LibsApp
dejarla en la carpeta que es indicada en la propiedad basedirWL
```

1) Agregar o ubicar libreria del OWSM
fisicamente llevar la libreria a una carpeta del sistema: com.oracle.webservices.jaxrs.fmw.jrf-jaxrs-client-impl


2) Agregar la propiedad en el pom


    <properties>
        <basedirWL>C:\Oracle\Middleware\oracle_common\modules\clients</basedirWL>
    </properties>

3) Agregar dependencia al proyecto de Ejbs

        <dependency>
            <groupId>com.roufid.tutorials</groupId>
            <artifactId>example-app</artifactId>
            <version>1.0</version>
            <scope>system</scope>
            <systemPath>${basedirWL}/com.oracle.webservices.wls.jaxws-owsm-client.jar</systemPath>
        </dependency>
