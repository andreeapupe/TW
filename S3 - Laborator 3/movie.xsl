<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/">
<html> 
<body>
  <h2>Best movies of all time</h2>
  <table border="4">
    <tr bgcolor="#3579e5">
      <th style="text-align:center">Title</th>
      <th style="text-align:center">Genre</th>
      <th style="text-align:center">Director</th>
      <th style="text-align:center">Premiere</th>

    </tr>
    <xsl:for-each select="list/movie">
    <tr>
      <td><xsl:value-of select="title"/></td>
      <td><xsl:value-of select="genre"/></td>
      <td><xsl:value-of select="director"/></td>
      <td><xsl:value-of select="premiere"/></td>

    </tr>
    </xsl:for-each>
  </table>
</body>
</html>
</xsl:template>
</xsl:stylesheet>
