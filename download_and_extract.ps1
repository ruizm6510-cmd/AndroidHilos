$url = "https://repo1.maven.org/maven2/org/apache/pdfbox/pdfbox-app/3.0.1/pdfbox-app-3.0.1.jar"
$output = "pdfbox-app.jar"
if (!(Test-Path $output)) {
    Write-Host "Downloading PDFBox..."
    Invoke-WebRequest -Uri $url -OutFile $output
}
Write-Host "Extracting text..."
java -jar $output export:text -i "C:/Users/lenov/Downloads/6 Android hilos de ejecución y sensores.pdf" -o pdf_extracted.txt
if (Test-Path "pdf_extracted.txt") {
    Write-Host "Extraction successful!"
    Get-Content "pdf_extracted.txt" -TotalCount 50
} else {
    Write-Host "Extraction failed"
}
