def ant = new AntBuilder()
ant.echo(file:'HelloWorld.java', '''
    class HelloWorld { public static void main(String[] args) { System.out.println("Hello World"); }}
''')
ant.javac(srcdir:'.', includes:'HelloWorld.java', fork:'true')
ant.java(classpath:'.', classname:'HelloWorld', fork:'true')
ant.echo('Done')
