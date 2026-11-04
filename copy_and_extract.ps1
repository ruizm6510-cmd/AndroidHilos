$file = Get-ChildItem "C:/Users/lenov/Downloads/" -Filter "*hilos*" | Select-Object -First 1
if ($file) {
    Copy-Item $file.FullName "pdf_guide.pdf" -Force
    Write-Host "Copied to pdf_guide.pdf"
    java -jar pdfbox-app.jar export:text -i pdf_guide.pdf -o pdf_extracted.txt
    if (Test-Path "pdf_extracted.txt") {
        Write-Host "Extraction successful!"
        Get-Content "pdf_extracted.txt" -TotalCount 40
    }
}
