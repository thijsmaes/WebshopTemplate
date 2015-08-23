require 'css_parser'

include CssParser

class MakeImportantAction
	def initialize(rule, important_declarations)
		@rule = rule
		@important_declarations = important_declarations
	end

	def run(parser)
		declaration_lists = parser.find_by_selector(@rule)
		declaration_lists.map! do |declaration_list|
			declarations = declaration_list.split(';')
			declarations.map! do |declaration|
				declaration.strip!
				converted_declaration = declaration
				@important_declarations.each do |important_declaration|
					if declaration.start_with?("#{important_declaration}:")
						converted_declaration = "#{declaration} !important"
						break
					end
				end
				converted_declaration
			end
			declarations << ''
			declarations_joined = declarations.join(';')

			# TODO Replace the existing block
			parser.add_block! "#{@rule}{#{declarations_joined}}"
		end
	end
end

class CopyAction
	def initialize(original_rule, rule)
		@original_rule = original_rule
		@rule = rule
	end

	def run(parser)
		original_declarations = parser.find_by_selector(@original_rule)
		parser.add_block! "#{@rule}{#{original_declarations.join}}"
	end
end

actions = [
	MakeImportantAction.new('#wrapper', ['margin', 'width', 'clear']),
	CopyAction.new('#federalheader ul.language-switcher', '#federalheader .language-switcher'),
	CopyAction.new('#federalheader ul.language-switcher li', '#federalheader .language-switcher .m-language-button'),
	CopyAction.new('#federalheader ul.language-switcher li a', '#federalheader .language-switcher .m-language-button > span'),
	CopyAction.new('#federalheader ul.language-switcher li a:hover', '#federalheader .language-switcher .m-language-button > span:hover'),
	CopyAction.new('#federalheader ul.language-switcher li a.active', '#federalheader .language-switcher .m-language-button > span.active'),
	CopyAction.new('#block-menu-main .content li', '#block-menu-main .content .m-menu-button'),
	CopyAction.new('#block-menu-main .content li a', '#block-menu-main .content .m-menu-button > span'),
	CopyAction.new('#block-menu-main .content li.active-trail a', '#block-menu-main .content .m-menu-button.active-trail > span'),
	CopyAction.new('#block-menu-main .content li:hover a', '#block-menu-main .content .m-menu-button:hover > span'),
	CopyAction.new('#frame-menu ul', '.v-tabsheet-tabs'),
	CopyAction.new('#frame-menu ul li a', '.v-tabsheet-tabitemcell .v-tabsheet-tabitem .v-caption.v-caption'),
	CopyAction.new('#frame-menu ul li.active a', '.v-tabsheet-tabitemcell .v-tabsheet-tabitem-selected .v-caption.v-caption'),
	CopyAction.new('#frame-menu ul', '.m-tabsheet-caption-container'),
	CopyAction.new('#frame-menu ul li', '.m-tabsheet-caption-container .m-tabsheet-caption'),
	CopyAction.new('#frame-menu ul li a', '.m-tabsheet-caption-container .m-tabsheet-caption .m-tabsheet-caption-wrap'),
	CopyAction.new('#frame-menu ul li a:hover', '.m-tabsheet-caption-container .m-tabsheet-caption .m-tabsheet-caption-wrap:hover'),
	CopyAction.new('#frame-menu ul li.active a', '.m-tabsheet-caption-container .m-tabsheet-caption.m-selected .m-tabsheet-caption-wrap'),
	CopyAction.new('#frame-content', '.m-tabsheet-content-container'),
	CopyAction.new('.left-menu li a', '.left-menu .m-submenu-item > span'),
	CopyAction.new('.left-menu li a:hover', '.left-menu .m-submenu-item > span:hover'),
	CopyAction.new('.left-menu li a.active', '.left-menu .m-submenu-item.m-selected > span'),
	CopyAction.new('input.person', '.m-search-person-button'),
	CopyAction.new('input.person:hover', '.m-search-person-button:hover'),
	CopyAction.new('input.home', '.m-search-home-button'),
	CopyAction.new('input.home:hover', '.m-search-home-button:hover'),
	CopyAction.new('input.home:hover', '.m-search-home-button:hover'),
	CopyAction.new('.form-submit', '.m-button'),
	CopyAction.new('.form-submit:hover', '.m-button:hover'),
	CopyAction.new('.ac-container label', '.m-panel-header-container'),
	CopyAction.new('.ac-container article', '.m-panel-content-container'),
	CopyAction.new('.ac-container input:checked ~ article', '.m-panel-content-container'),
	CopyAction.new('fieldset', '.m-fieldset'),
	CopyAction.new('table', '.m-table'),
	CopyAction.new('tr:nth-child(even)', '.m-table-row:nth-child(even)'),
	CopyAction.new('td', '.m-table-cell'),
	MakeImportantAction.new('#federalheader .language-switcher .m-language-button', ['margin-right', 'padding']),
	MakeImportantAction.new('#block-menu-main .content .m-menu-button', ['padding'])
]

source = IO.read('fedasil-original.css')
source.gsub!("\n", '')

parser = CssParser::Parser.new
parser.load_string!(source)

actions.each do |action|
	action.run(parser)
end

File.write('fedasil-converted.scss', parser.to_s)