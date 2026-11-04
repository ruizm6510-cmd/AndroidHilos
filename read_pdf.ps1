$file = Get-ChildItem "C:/Users/lenov/Downloads/" -Filter "*hilos*" | Select-Object -First 1
if ($file) {
    Write-Host "Found file: $($file.FullName)"
    $bytes = [System.IO.File]::ReadAllBytes($file.FullName)
    $text = [System.Text.Encoding]::UTF8.GetString($bytes)
    # Let's write raw text or search for exercise headings
    Set-Content -Path "extracted_pdf_text.txt" -Value $text -Encoding UTF8
    Write-Host "Saved to extracted_pdf_text.txt. Length: $($text.Length)"
} else {
    Write-Host "File not found"
}
