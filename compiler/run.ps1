
iex "javac compiler/*.java compiler/ast/*.java -d bin" -ErrorVariable CompilerOutput
if (-Not [string]::IsNullOrWhitespace($CompilerOutput)) {
    Write-host "$CompilerOutput"
    Write-host "Compilation failed"
    exit
}
cd bin
Invoke-Expression "java compiler.App"
cd ..
