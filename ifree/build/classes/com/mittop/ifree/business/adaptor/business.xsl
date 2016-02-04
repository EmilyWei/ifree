<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"

	xmlns:java="com.mittop.ifree.business.adaptor" exclude-result-prefixes="java"

	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method='xml' version='1.0' encoding='UTF-8'
		indent='yes' cdata-section-elements="sqlList sqlEdit editLayout" />

	<xsl:strip-space elements="*" />

	<xsl:template match="/">
		<business>

			<xsl:attribute name="name">
				<xsl:value-of select="root/bizModel/@TableName" />
			</xsl:attribute>
			<xsl:attribute name="cnName">
				<xsl:value-of select="root/bizModel/@TableNameCn" />
			</xsl:attribute>
			<xsl:attribute name="tableName">
				<xsl:value-of select="root/bizModel/@TableName" />
			</xsl:attribute>
			<sqlList>
				<xsl:value-of select="root/bizModel/ListSQL" />
			</sqlList>
			<sqlEdit>
				<xsl:value-of select="root/bizModel/DetailSQL" />
			</sqlEdit>
			<attributes>
				<xsl:for-each select="root/bizModel/Fields/Field">
					<attribute>
						<xsl:attribute name="name">
							<xsl:value-of select="@FieldName" />
						</xsl:attribute>
						<xsl:attribute name="cnName">
							<xsl:value-of select="@FieldNameCn" />
						</xsl:attribute>
						<xsl:attribute name="type">
							<xsl:value-of select="@FieldType" />
						</xsl:attribute>
						<xsl:attribute name="length">
							<xsl:value-of select="@FieldLength" />
						</xsl:attribute>

						<xsl:attribute name="order">
							<xsl:value-of select="@FieldOdr" />
						</xsl:attribute>



					</attribute>
				</xsl:for-each>


			</attributes>


			<lists>

				<xsl:for-each select="root/bizModel/FieldExts">
					<list>
						<listPropertyStyles>
							<xsl:for-each select="FieldExt">
								<!-- <xsl:attribute name="Index"> <xsl:value-of select="@Index"/> 
									</xsl:attribute> -->
								<listPropertyStyle>
									<xsl:attribute name="name">
								<xsl:value-of select="@FieldName" />
							</xsl:attribute>

								</listPropertyStyle>

							</xsl:for-each>
						</listPropertyStyles>


					</list>
				</xsl:for-each>
			</lists>

			<forms>
				<xsl:for-each select="root/bizModel">
					<form>
						<editLayout>
							<!--<xsl:value-of select="substring('Beatles',1,4)"/> -->
							<!--<xsl:variable name="FeatureInfo" select="FormHtml" /> -->
							<!--<xsl:value-of disable-output-escaping="yes" select="replace($FeatureInfo,'Feature=','TESTING')"/> -->
							<!--<xsl:value-of disable-output-escaping="yes" select="translate($FeatureInfo,'{','${')"/> -->

							<xsl:value-of disable-output-escaping="yes"
								select="java:Function.doLayout(FormHtml)" />
						</editLayout>
						<formPropertyEvents>
							<xsl:for-each select="FieldEvents/event">
								<formPropertyEvent>
									<action>
										<xsl:value-of select="name" />
									</action>
								</formPropertyEvent>
							</xsl:for-each>
						</formPropertyEvents>
						<xsl:for-each select="FieldStyles">
							<formPropertyStyles>
								<!-- <xsl:attribute name="Index"> <xsl:value-of select="@Index"/> 
									</xsl:attribute> -->
								<xsl:for-each select="Field">
									<formPropertyStyle>
										<xsl:attribute name="name">
								<xsl:value-of select="@FieldName" />
							</xsl:attribute>
										<xsl:attribute name="visiable">
								<xsl:value-of select="@FieldInDisp" />
							</xsl:attribute>
										<xsl:attribute name="editable">
								<xsl:value-of select="@FieldRead" />
							</xsl:attribute>
										<xsl:attribute name="required">
								<xsl:value-of select="@FieldNull" />
							</xsl:attribute>
									</formPropertyStyle>
								</xsl:for-each>
							</formPropertyStyles>
						</xsl:for-each>
					</form>
				</xsl:for-each>
			</forms>




			<businesses>
				<xsl:for-each select="root/bizModel/bizModel">
					<business>

						<xsl:attribute name="name">
				<xsl:value-of select="@TableName" />
			</xsl:attribute>
						<xsl:attribute name="cnName">
				<xsl:value-of select="@TableNameCn" />
			</xsl:attribute>
						<xsl:attribute name="tableName">
				<xsl:value-of select="@TableName" />
			</xsl:attribute>


						<attributes>
							<xsl:for-each select="Fields/Field">
								<attribute>
									<xsl:attribute name="name">
							<xsl:value-of select="@FieldName" />
						</xsl:attribute>
									<xsl:attribute name="cnName">
							<xsl:value-of select="@FieldNameCn" />
						</xsl:attribute>
									<xsl:attribute name="type">
							<xsl:value-of select="@FieldType" />
						</xsl:attribute>
									<xsl:attribute name="length">
							<xsl:value-of select="@FieldLength" />
						</xsl:attribute>

									<xsl:attribute name="width">
							<xsl:value-of select="@FieldWidth" />
						</xsl:attribute>

									<xsl:attribute name="order">
							<xsl:value-of select="@FieldOdr" />
						</xsl:attribute>




								</attribute>
							</xsl:for-each>


						</attributes>


					</business>

				</xsl:for-each>
			</businesses>
		</business>


	</xsl:template>
</xsl:stylesheet>