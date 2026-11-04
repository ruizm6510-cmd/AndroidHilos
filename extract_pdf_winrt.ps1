$pdfPath = "C:\Users\lenov\Downloads\6 Android hilos de ejecución y sensores.pdf"
$outputPath = "C:\Users\lenov\AndroidStudioProjects\Androidhilos\pdf_text_winrt.txt"

Add-Type -AssemblyName System.Runtime.WindowsRuntime
$asTaskGeneric = [System.WindowsRuntimeSystemExtensions].GetMethods() | ? { $_.Name -eq 'AsTask' -and $_.GetParameters().Count -eq 1 -and $_.GetParameters()[0].ParameterType.Name -eq 'IAsyncOperation`1' }

function Await($asyncOp, $resultType) {
    $wt = $asTaskGeneric.MakeGenericMethod($resultType)
    $task = $wt.Invoke($null, @($asyncOp))
    $task.Wait()
    return $task.Result
}

[Windows.Storage.StorageFile, Windows.Storage, ContentType = WindowsRuntime] | Out-Null
$fileOp = [Windows.Storage.StorageFile]::GetFileFromPathAsync($pdfPath)
$file = Await $fileOp ([Windows.Storage.StorageFile])

[Windows.Data.Pdf.PdfDocument, Windows.Data.Pdf, ContentType = WindowsRuntime] | Out-Null
$pdfOp = [Windows.Data.Pdf.PdfDocument]::LoadFromFileAsync($file)
$pdf = Await $pdfOp ([Windows.Data.Pdf.PdfDocument])

$sb = [System.Text.StringBuilder]::new()
for ($i = 0; $i -lt $pdf.PageCount; $i++) {
    $page = $pdf.GetPage($i)
    $stream = [Windows.Storage.Streams.InMemoryRandomAccessStream]::new()
    $page.RenderToStreamAsync($stream).AsTask().Wait()
    # Wait, RenderToStream is for images. To get text, we can use TextExtraction or parse page text:
    # Actually, Windows.Data.Pdf doesn't have direct text extraction unless using page text extraction or stream.
    # Let's see if page has text extraction or read text from page stream.
}
Write-Host "Page count: $($pdf.PageCount)"
