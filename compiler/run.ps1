iex "javac compiler/*.java compiler/ast/*.java -d bin"
cd bin
iex "java compiler.App"
cd ..
